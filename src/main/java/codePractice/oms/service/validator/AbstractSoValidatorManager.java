package main.java.codePractice.oms.service.validator;


import main.java.codePractice.oms.util.StringUtil;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xudong1.zhang
 */
public abstract class AbstractSoValidatorManager<T extends IBaseValidator> {

    private Map<String, T> validatorMap;

    private final Map<String, SoValidatorChain<T>> validatorChainMap = new ConcurrentHashMap<>(16);

    private final Map<String, Object> lockMap = new ConcurrentHashMap<>(16);

    private final SoValidatorChain<T> EMPTY_CHAIN = new SoValidatorChain<>();

    @Resource
    private Environment env;

    @PostConstruct
    public void init() {
        T[] validators = getValidatorsByType();
        if (validators != null && validators.length > 0) {
            validatorMap = new HashMap<>(validators.length);
            for (T validator : validators) {
                if (validatorMap.containsKey(validator.getCode())) {
//                    throw new BusinessException("存在多个名为" + validator.getCode() + "的" + validator.getType() + "校验器");
                }
                validatorMap.put(validator.getCode(), validator);
            }
        } else {
            validatorMap = new HashMap<>(0);
        }
    }

    /**
     * 获取校验器
     *
     * @return
     */
    public abstract T[] getValidatorsByType();

    protected String getValidatorCodes(String chainKey) {
        return env.getProperty(chainKey);
    }

    public SoValidatorChain<T> getValidatorChain(String chainKey) {
        String validatorCodes = getValidatorCodes(chainKey);
        if (validatorCodes == null){
//            throw new BusinessException(chainKey+"未配置校验器");
        }
//        if (StringUtil.isBlank(validatorCodes)) {
//            return EMPTY_CHAIN;
//        }

        SoValidatorChain<T> chain = validatorChainMap.get(chainKey);
        if (chain != null && chain.getValidatorCodes().equals(validatorCodes)) {
            return chain;
        }

        lockMap.putIfAbsent(chainKey, new Object());
        // 同一订单类型的卡控上锁
        synchronized (lockMap.get(chainKey)) {
            chain = validatorChainMap.get(chainKey);
            if (chain != null && chain.getValidatorCodes().equals(validatorCodes)) {
                return chain;
            }

//            log.info("load validator chain for '{}' with codes '{}'", chainKey, validatorCodes);
            chain = new SoValidatorChain<>();
            chain.setValidatorCodes(validatorCodes);
//            if (StringUtil.isBlank(validatorCodes)) {
//                validatorChainMap.putIfAbsent(chainKey, chain);
//                return chain;
//            }
//            for (String validatorCode : validatorCodes.split(Constant.CHAR_COMMA)) {
//                T validator = validatorMap.get(validatorCode.trim());
//                if (validator != null) {
//                    chain.addValidator(validator);
//                } else {
//                    log.error("can not find validator with code '{}'", validatorCode.trim());
//                }
//            }
            validatorChainMap.putIfAbsent(chainKey, chain);
        }
        return chain;
    }

    public Map<String, SoValidatorChain<T>> getValidatorChainMap() {
        return validatorChainMap;
    }
}
