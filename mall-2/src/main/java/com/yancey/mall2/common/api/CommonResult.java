package com.yancey.mall2.common.api;

/**
 * @ClassName CommonResult
 * @Description TODO Common Return Object
 * @Author Yancey
 * @Date 2022/6/3 15:50
 * @Version 1.0
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {}
    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    /**
     * @Author Yancey
     * @Description //TODO
     * @Date 15:51 2022/6/3
     * @Param null 1
     * @return
     **/
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }
    /**
     * @Author Yancey
     * @Description //TODO the result of success
     * @Date 15:51 2022/6/3
     * @Param data : After operation success get data
     * @Param message : After operation success get message
     * @return com.yancey.mall2.common.api.CommonResult<T>
     **/
    public static <T> CommonResult<T> success(T data, String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }
    /**
     * @Author Yancey
     * @Description //TODO return the failure message
     * @Date 15:51 2022/6/3
     * @Param errorCode : The Error Code
     * @return
     **/
    public static <T> CommonResult<T> failed(IErrorCode errorCode){
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }
    /**
     * @Author Yancey
     * @Description //TODO return the failure message
     * @Date 15:51 2022/6/3
     * @Param message : The Error Message
     * @return
     **/
    public static <T> CommonResult<T> failed(String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }
    /**
     * @Author Yancey
     * @Description //TODO return the failure message
     * @Date 15:51 2022/6/3
     * @Param
     * @return
     **/
    public static <T> CommonResult<T> failed(){
        return failed(ResultCode.FAILED);
    }
    /**
     * @Author Yancey
     * @Description //TODO return the message that the parameters can't through validation
     * @Date 15:51 2022/6/3
     * @Param
     * @return
     **/
    public static <T> CommonResult<T> validateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }
    /**
     * @Author Yancey
     * @Description //TODO return the message that the parameters can't through validation
     * @Date 16:30 2022/6/3
     * @Param message : The validation Message
     * @return
     **/
    public static <T> CommonResult<T> validateFailed(String message){
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }
    /**
     * @Author Yancey
     * @Description //TODO can't login message
     * @Date 16:33 2022/6/3
     * @Param data : The data of not login
     * @return
     **/
    public static <T> CommonResult<T> unauthorized(T data){
       return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }
    /**
     * @Author Yancey
     * @Description //TODO can't authorization message
     * @Date 16:35 2022/6/3
     * @Param data : The data of not authorization
     * @return
     **/
    public static <T> CommonResult<T> forbidden(T data){
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
    public long getCode() {
        return code;
    }
    public void setCode(long code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}

