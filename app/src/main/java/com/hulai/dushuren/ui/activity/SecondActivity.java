package com.hulai.dushuren.ui.activity;

import android.widget.TextView;


import com.hulai.dushuren.R;
import com.hulai.dushuren.base.BaseActivity;
import com.hulai.dushuren.mvp.model.bean.Teacher;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by QingMei on 2017/7/31.
 * desc:
 */

public class SecondActivity extends BaseActivity {

    @Inject
    String className;
    @Inject
    Teacher teacher;
    @BindView(R.id.tv_content)
    TextView textView;

    @Override
    public int getContentViewLayoutID() {
        return R.layout.activity_second;
    }

    @Override
    protected void bindView() {
        textView.setText(className + teacher.toString());
    }
}
