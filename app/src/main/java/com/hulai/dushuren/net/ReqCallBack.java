package com.hulai.dushuren.net;



import com.hulai.dushuren.base.ErrorBean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by JoJo on 2017/10/17.
 * wechat：18510829974
 * description：
 */
public  abstract class ReqCallBack<T> {

    /**抽象类范型的数据类型*/
    protected Type type;
    /**请求地址*/
    private String requestUrl;
    /**请求参数*/
    private HashMap<String, String> paramsMap;
    public ReqCallBack() {
        Type superClass = getClass().getGenericSuperclass();
        type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }


    /**
     * 响应成功
     * @param result
     */
    public  abstract  void onReqSuccess(T result);


    /**
     * 请求失败
     * @param result
     */
    public  abstract  void onFailure(String result);
    /**
     * 响应失败
     * @param error
     */
    public abstract void onReqFailed(ErrorBean error);

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
    public HashMap<String, String> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(HashMap<String, String> paramsMap) {
        this.paramsMap = paramsMap;
    }

}
