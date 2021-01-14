package main.java.codePractice.oms.service.validator;

import main.java.codePractice.oms.dto.SalesOrderHeaderDTO;
import main.java.codePractice.oms.dto.ServiceResult;
import main.java.codePractice.oms.service.validator.IBaseValidator;

import java.util.Map;

/**
 * @className: ISoBusinessValidator
 * @description: so所有的卡控
 * @author: jxx
 * @date: 2021/1/14
 **/
public interface ISoBusinessValidator extends IBaseValidator {

    String VALIDATE_CONTEXT = "validateContext";

    /**
     * 校验器类型
     *
     * @return
     */
    @Override
    default String getType() {
        return "SoBusiness";
    }

    /**
     * 订单创建基本校验
     */
    ServiceResult validate(SalesOrderHeaderDTO header, Map<String, Object> ext);

    /**
     * 校验失败回调
     *
     * @param header
     * @param ext
     * @param validateResult
     */
    void failCallback(SalesOrderHeaderDTO header, Map<String, Object> ext, ServiceResult validateResult);
}
