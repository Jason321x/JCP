package main.java.codePractice.oms.service.validator;

public interface IBaseValidator {

    /**
     * 校验器编码
     *
     * @return
     */
    String getCode();

    /**
     * 校验器名称
     *
     * @return
     */
    String getName();

    /**
     * 校验器类型
     *
     * @return
     */
    String getType();

    /**
     * 校验业务描述, 务必说明校验器的主要卡控点
     * @return
     */
    String getDesc();

}
