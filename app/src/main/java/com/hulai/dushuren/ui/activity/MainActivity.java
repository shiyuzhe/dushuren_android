package com.hulai.dushuren.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.hulai.dushuren.R;
import com.hulai.dushuren.base.BaseActivity;
import com.hulai.dushuren.mvp.model.bean.Student;
import com.hulai.dushuren.mvp.model.bean.Teacher;
import com.hulai.dushuren.mvp.contract.MainContract;
import com.hulai.dushuren.mvp.presenter.MainPresenter;
import com.hulai.dushuren.mvp.model.bean.BookBean;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * Created by QingMei on 2017/7/28.
 * desc:
 */

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    String className;
    @Inject
    SharedPreferences sp;
    @Inject
    MainPresenter presenter;
    @Inject
    Student s1;
    @Inject
    Student s2;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public int getContentViewLayoutID() {
        return R.layout.activity_main;
    }


    @Override
    protected void bindView() {
        tvContent.setText(className + "\n" +
                s2.toString() + "\n" +
                s1.toString());
    }

    public void gotoSecond(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void requestHttp(View view) {
        presenter.requestHttp();
        presenter.getMsg("id", "ssyz");
        presenter.getTeacher("237475019");
    }

    public void onGetMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMsg(Teacher teacher) {

        Toast.makeText(this, teacher.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTeacherBean(BookBean teacherBean) {
        CharSequence text = tvContent.getText();
        tvContent.setText(text + "--" + teacherBean.toString());
    }


}
