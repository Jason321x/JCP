package main.java.codePractice.oms.dto;

import java.io.Serializable;

/**
 * @className: ServiceResult
 * @description: TODO 类描述
 * @author: jxx
 * @date: 2021/1/14 3:39 PM
 **/
public class ServiceResult<T>
      //  extends TraceVO
        implements Serializable {
    private static final long serialVersionUID = -394529804715984961L;

    public static ServiceResult successInstance(){
        return new ServiceResult(200,"成功");
    }

    /**
     * 返回成功200代码添加
     */
    public static final Integer CODE_OK_200 = 200;

    /**
     * 冻结返回code
     */
    public static final Integer CODE_OK_201 = 201;

    /**
     * 调用外部系统出错
     */
    public static final Integer CODE_ERR_400 = 400;
    /**
     * 调用外部系统出错
     */
    public static final Integer CODE_ERR_404 = 404;

    /**
     * 返回成功408代码添加,代表超时
     */
    public static final Integer CODE_TIME_OUT_408 = 408;

    private Integer code;
    private String msg;
    private long total;
    private T data;

    public ServiceResult() {

    }

    public ServiceResult(T data) {
        this.data = data;
    }

    public ServiceResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ServiceResult [");
        if (code != null) {
            builder.append("code=").append(code).append(", ");
        }
        if (msg != null) {
            builder.append("msg=").append(msg).append(", ");
        }
        if (total != 0) {
            builder.append("total=").append(total).append(", ");
        }
        if (data != null) {
            builder.append("data=").append(data);
        }
        builder.append("]");
        return builder.toString();
    }


    public static ServiceResult createResultMsg(int code, String msg, String... data) {
        ServiceResult result = new ServiceResult();
//        result.setCode(code);
//        result.setMsg(msg);
//        if (null != data && data.length > 0) {
//            result.setData(data[0]);
//        }
        return result;
    }

    public static <T> ServiceResult<T> fail(int code, String msg) {
        ServiceResult<T> result = new ServiceResult<>(null);
//        result.setCode(code);
//        result.setMsg(msg);
        return result;
    }


    public static <T> ServiceResult<T> fail(int code, String msg, T data) {
        ServiceResult<T> result = new ServiceResult<>(data);
//        result.setCode(code);
//        result.setMsg(msg);
        return result;
    }


    @Deprecated
    public static ServiceResult ok() {
        return createResultMsg(200, "成功");
    }


    public static <T> ServiceResult<T> success(T obj) {
        ServiceResult<T> serviceResult = new ServiceResult<>(obj);
//        serviceResult.setCode(BaseResponseCodeEnum.SUCCESS.getCode());
//        serviceResult.setMsg(BaseResponseCodeEnum.SUCCESS.getDesc());
//        serviceResult.setData(obj);
        return serviceResult;
    }

    public static <T> ServiceResult<T> success(Integer code,T obj) {
        ServiceResult<T> serviceResult = new ServiceResult<>(obj);
//        serviceResult.setCode(code);
//        serviceResult.setMsg(BaseResponseCodeEnum.SUCCESS.getDesc());
//        serviceResult.setData(obj);
        return serviceResult;
    }

    public boolean isSuccess() {
        return CODE_OK_200.equals(code) ||  CODE_OK_201.equals(code);
    }

    public static ServiceResult failMsg(String msg) {
        ServiceResult result = new ServiceResult();
//        result.setCode(ServiceResultCodeEnum.SYSTEM_ERROR.getCode());
//        result.setMsg(msg);
        return result;
    }
}
