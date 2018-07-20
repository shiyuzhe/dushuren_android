package com.hulai.dushuren.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/**
 * Created by QingMei on 2017/7/31.
 * desc:
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(getContentViewLayoutID());
        ButterKnife.bind(this);
        bindView();
    }

    protected abstract int getContentViewLayoutID();

    protected abstract void bindView();
}
