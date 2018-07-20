package com.hulai.dushuren.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;


import com.hulai.dushuren.di.DaggerMyAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


/**
 * Created by shiyuzhe on 2017/7/28.
 * desc:
 */

public class MyApplication extends Application implements HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMyAppComponent.create().inject(this);
        mInstance = this;
        mContext = getApplicationContext();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }


    private static Context mContext;

    public static MyApplication mInstance = null;

    public static MyApplication getInstance() {
        return mInstance;
    }

    public static Context getmContext(){
        return mContext;
    }


}
