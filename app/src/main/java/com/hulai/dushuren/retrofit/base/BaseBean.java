package com.hulai.dushuren.retrofit.base;

/**
 * Created by Administrator on 2018/3/12.
 */

public class BaseBean<T> {
    private boolean success;
    private String message;
    private T object;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
