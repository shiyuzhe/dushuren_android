package com.hulai.dushuren.di.module;


import com.hulai.dushuren.mvp.model.bean.Teacher;
import com.hulai.dushuren.di.scope.ActivityScope;
import com.hulai.dushuren.ui.activity.SecondActivity;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class SecondActivityModule {

    @Provides
    static String provideName() {
        return SecondActivity.class.getName();
    }

    @Provides
    @ActivityScope
    static Teacher provideTeacher() {
        return new Teacher();
    }
}
