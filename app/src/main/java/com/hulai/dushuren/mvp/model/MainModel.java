package com.hulai.dushuren.mvp.model;


import android.util.Log;

import com.hulai.dushuren.mvp.model.bean.Teacher;
import com.hulai.dushuren.mvp.base.BaseMvpListener;
import com.hulai.dushuren.mvp.contract.MainContract;
import com.hulai.dushuren.retrofit.RetrofitFactory;
import com.hulai.dushuren.retrofit.base.BaseBean;
import com.hulai.dushuren.retrofit.base.BaseObserver;
import com.hulai.dushuren.retrofit.ApiService;
import com.hulai.dushuren.mvp.model.bean.BookBean;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */

public class MainModel implements MainContract.Model {

    @Inject
    public MainModel() {
    }

    public String returnMessage() {
        return "qingmei2";
    }

    @Override
    public Teacher getMsg(String id, String name) {

        return new Teacher(id, name);
    }

    @Override
    public void getTeacher(String id, final BaseMvpListener<BookBean> listener) {
        RetrofitFactory.getInstance().getRetrofit()
                .create(ApiService.class)
                .getBook(id)
                .subscribeOn(Schedulers.io())               //在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  //回到主线程去处理请求结果
                .subscribe(new BaseObserver<BookBean>() {
                    @Override
                    protected void onSuccees(BaseBean<BookBean> t) throws Exception {
                        listener.onSuccess(1, t.getObject());
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        Log.e("syz", isNetWorkError + "ss");
                        listener.onException(e.getMessage());
                    }
                });
    }

}
