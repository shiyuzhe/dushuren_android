package com.hulai.dushuren.mvp.base;


import com.hulai.dushuren.base.ErrorBean;

/**
 * Created by JoJo on 2018/4/1.
 * wechat：18510829974
 * description：
 */
public interface BaseMvpListener<T> {
    /**
     * 请求接口成功
     *
     * @param event_tag
     * @param data
     */
    void onSuccess(int event_tag, T data);

    /**
     * @param error
     */
    void onBusinessError(ErrorBean error);

    /**
     * 服务器连接失败：超时无响应等
     *
     * @param msg
     */
    void onException(String msg);
}
