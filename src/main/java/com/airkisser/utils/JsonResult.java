package com.airkisser.utils;

import java.io.Serializable;

/**
 * Json内容封装
 * @param <T> 返回的数据
 *           如果出现异常，该参数将被置为null，message置为异常信息
 *           返回状态success为异常标识，无异常为true
 */
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 4095512373698538582L;

    private boolean success = true;//代表方法有没有异常
    private T data;
    private String message;

    public JsonResult(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
