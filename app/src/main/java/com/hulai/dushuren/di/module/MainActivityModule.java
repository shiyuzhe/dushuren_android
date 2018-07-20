package com.hulai.dushuren.di.module;

import android.content.Context;
import android.content.SharedPreferences;


import com.hulai.dushuren.mvp.model.bean.Student;
import com.hulai.dushuren.di.scope.ActivityScope;
import com.hulai.dushuren.ui.activity.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    static String provideName() {
        return MainActivity.class.getName();
    }

    @Provides
    static SharedPreferences provideSp(MainActivity activity) {
        return activity.getSharedPreferences("def", Context.MODE_PRIVATE);
    }

    @Provides
    @ActivityScope
    static Student provideStudent() {
        return new Student();
    }
}
