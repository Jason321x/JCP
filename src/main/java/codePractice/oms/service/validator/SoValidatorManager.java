package main.java.codePractice.oms.service.validator;

import main.java.codePractice.oms.dto.SalesOrderHeaderDTO;
import main.java.codePractice.oms.dto.ServiceResult;
import main.java.codePractice.oms.util.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static main.java.codePractice.oms.service.validator.ISoBusinessValidator.VALIDATE_CONTEXT;


/**
 * @author xudong1.zhang
 */
@Component
public class SoValidatorManager extends AbstractSoValidatorManager<ISoBusinessValidator> {

    @Resource
    private ISoBusinessValidator[] validators;

    @Override
    public ISoBusinessValidator[] getValidatorsByType() {
        return validators;
    }

//    @Resource
//    public IListOfValuesService listOfValuesService;

    /**
     * 白名单内卡控，可交给上游来控制是否跳过
     */
    @Value("#{'${whitelist.skip.item.validator:freeze}'.split(',')}")
    private Set<String> skipItemValidatorWhiteSet;

    public ServiceResult<List<String>> validate(String chainKey, SalesOrderHeaderDTO header, Map<String, Object> ext) {
        List<String> msgList = new ArrayList<>();
        ServiceResult validateResult = ServiceResult.success("");

        // 上下文
        ext.put(VALIDATE_CONTEXT, new ValidateContext(header));
        for (ISoBusinessValidator validator : getValidatorChain(chainKey).getValidatorList()) {
//            List<SalesOrderItemDTO> ignoredItemList = Lists.newArrayList();
//            List<SalesOrderItemDTO> notIgnoredItemList = Lists.newArrayList();
//            for (SalesOrderItemDTO item : header.getItems()) {
//                String skipItemValidatorList = item.getSkipItemValidatorList();
//                if (StringUtil.isNotBlank(skipItemValidatorList)) {
//                    Set<String> skipItemValidatorSet = new HashSet<String>(Arrays.asList(skipItemValidatorList.split(",")));
//                    if (skipItemValidatorWhiteSet.contains(validator.getCode()) && skipItemValidatorSet.contains(validator.getCode())) {
//                        ignoredItemList.add(item);
//                        continue;
//                    }
//                }
//                notIgnoredItemList.add(item);
//            }
//            // 临时去掉跳过的行
//            if (CollectionUtil.isNotEmpty(ignoredItemList)) {
//                if (CollectionUtil.isEmpty(notIgnoredItemList)) {
//                    log.info("skip validate  {}", validator.getCode());
//                    continue;
//                }
//                header.setItems(notIgnoredItemList);


//            log.info("to validate so by {}", validator.getCode());
            validateResult = validator.validate(header, ext);
//            log.info("validate so by {}, res: {}", validator.getCode(), JSON.toJSONString(validateResult));
//
//            if (CollectionUtil.isNotEmpty(ignoredItemList)) {
//                // 加回跳过的行
//                header.getItems().addAll(ignoredItemList);
//            }
//
//            if (validateResult.getCode().equals(ServiceResultCodeEnum.FREEZE.getCode())) {
//                log.info("validate so freeze by {}, {}", validator.getCode(), validateResult.getMsg());
////                validator.failCallback(header, ext, validateResult);
////                msgList.add(validateResult.getData().toString());
//            } else if (validateResult.getCode().equals(ServiceResultCodeEnum.UPDATE_ALLOCATE_FAIL.getCode())) {
//                log.info("validate so validate by {}, {}", validator.getCode(), validateResult.getMsg());
//                msgList.add(validateResult.getMsg());
//                return ServiceResult.fail(validateResult.getCode(), JSON.toJSONString(validateResult.getData()), msgList);
//            } else if (!validateResult.isSuccess()) {
//                log.info("validate so fail by {}, {}, res data: {}", validator.getCode(), validateResult.getMsg(), validateResult.getData());
//                if (validateResult.getData() != null) {
//                    msgList.add(validateResult.getData().toString());
//                } else {
//                    msgList.add(validateResult.getMsg());
//                }
//                break;
//            }
//        }
//
//        if (msgList.isEmpty()) {
//            // 不存在校验失败消息, 开始处理冻结汇总
//            Set<String> freezeCodeSet = header.getDeliveryFreezeSet();
//            // 开票状态
//            String billingFreeze = header.getBillingFreeze();
//            Set<String> allFreezeCodeSet = Sets.newHashSet(freezeCodeSet);
//            if (CollectionUtil.isNotEmpty(freezeCodeSet)) {
//                List<String> freezeDescList = freezeCodeSet.stream()
//                        .filter(code -> !"05".equals(code))
//                        .map(code -> listOfValuesService.getOne(ListKeyDirect.deliveryFreeze.getCode(), "", code)
//                                .getName())
//                        .collect(Collectors.toList());
//                msgList.addAll(freezeDescList);
//            }
//
//            if(StringUtil.isNotBlank(billingFreeze)){
//                msgList.add(listOfValuesService.getOne(ListKeyDirect.invoiceFreeze.getCode(), "", billingFreeze).getName());
//            }
//            for (SalesOrderItemDTO item : header.getItems()) {
//                if (CollectionUtil.isNotEmpty(item.getDeliveryFreezeSet())) {
//                    allFreezeCodeSet.addAll(item.getDeliveryFreezeSet());
//                    List<String> freezeDescList = item.getDeliveryFreezeSet().stream()
//                            .filter(code -> !"05".equals(code))
//                            .map(code -> listOfValuesService.getOne(ListKeyDirect.deliveryFreeze.getCode(), "", code)
//                                    .getName())
//                            .collect(Collectors.toList());
//                    msgList.add("SKU[" + item.getMateriel() + "] " + String.join("; ", freezeDescList));
//                }
//            }
//            allFreezeCodeSet.remove("05");
//            if (CollectionUtil.isNotEmpty(allFreezeCodeSet)) {
//                validateResult.setCode(ServiceResultCodeEnum.FREEZE.getCode());
//                String msg = String.join("\n", msgList);
//                msgList.clear();
//                msgList.add(msg);
//            }
//        }
        }
//
//        if (msgList.isEmpty()
//                || validateResult.isSuccess()
//                || validateResult.getCode().equals(ServiceResultCodeEnum.FREEZE.getCode())) {
//            return ServiceResult.success(msgList);
//        } else {
//            return ServiceResult.fail(ServiceResultCodeEnum.SYSTEM_ERROR.getCode(), msgList.toString(), msgList);
//        }
        return null;
    }
}
