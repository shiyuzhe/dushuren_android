package com.hulai.dushuren.mvp.contract;


import com.hulai.dushuren.mvp.model.bean.Teacher;
import com.hulai.dushuren.mvp.base.BaseMvpListener;
import com.hulai.dushuren.mvp.model.bean.BookBean;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */

public interface MainContract {

    interface View {
        void getMsg(Teacher teacher);

        void showTeacherBean(BookBean teacherBean);

    }

    interface Presenter {
        void getMsg(String id, String name);

        void getTeacher(String id);
    }

    interface Model {
        Teacher getMsg(String id, String name);

        void getTeacher(String id, BaseMvpListener<BookBean> listener);
    }
}
