package com.hulai.dushuren.mvp.presenter;


import com.hulai.dushuren.base.ErrorBean;
import com.hulai.dushuren.mvp.model.bean.Teacher;
import com.hulai.dushuren.ui.activity.MainActivity;
import com.hulai.dushuren.mvp.base.BaseMvpListener;
import com.hulai.dushuren.mvp.contract.MainContract;
import com.hulai.dushuren.mvp.model.MainModel;
import com.hulai.dushuren.mvp.model.bean.BookBean;

import javax.inject.Inject;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */

public class MainPresenter implements MainContract.Presenter {

    private final MainActivity view;
    private final MainModel model;

    @Inject
    public MainPresenter(MainActivity view, MainModel model) {
        this.view = view;
        this.model = model;
    }

    public void requestHttp() {
        view.onGetMessage(model.returnMessage());
    }

    @Override
    public void getMsg(String id, String name) {
        Teacher msg = model.getMsg(id, name);
        view.getMsg(msg);
    }

    @Override
    public void getTeacher(String id) {
        BaseMvpListener<BookBean> listener = new BaseMvpListener<BookBean>() {
            @Override
            public void onSuccess(int event_tag, BookBean data) {
                view.showTeacherBean(data);
            }

            @Override
            public void onBusinessError(ErrorBean error) {
            }

            @Override
            public void onException(String msg) {
            }
        };
        model.getTeacher(id, listener);
    }
}
