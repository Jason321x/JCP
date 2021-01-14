package main.java.codePractice.oms.service.validator;


import java.util.ArrayList;
import java.util.List;

/**
 * @author xudong1.zhang
 */
public class SoValidatorChain<T extends IBaseValidator> {

    private String validatorCodes;

    private List<T> validatorList;

    public SoValidatorChain() {
        validatorList = new ArrayList<>();
    }

    public SoValidatorChain(T validator) {
        validatorList = new ArrayList<>();
        validatorList.add(validator);
    }

    public void addValidator(T validator) {
        validatorList.add(validator);
    }

    public String getValidatorCodes() {
        return validatorCodes;
    }

    public void setValidatorCodes(String validatorCodes) {
        this.validatorCodes = validatorCodes;
    }

    public List<T> getValidatorList() {
        return validatorList;
    }

    public void setValidatorList(List<T> validatorList) {
        this.validatorList = validatorList;
    }
}
