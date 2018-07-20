package com.hulai.dushuren.base;

/**
 * 作者：addison on 15/12/15 14:19
 * 邮箱：lsf@yonyou.com
 * 属性字段固定，字段定义可根据项目需求进行调整
 */
public class ErrorBean {
    private int status;
    private String msg;
    private String code;
    public int getStatus() {
        return status;
    }
    public String getMsg() {
        return msg;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ErrorBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
