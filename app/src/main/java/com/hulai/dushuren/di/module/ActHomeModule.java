package com.hulai.dushuren.di.module;

import com.hulai.dushuren.mvp.model.bean.Teacher;
import com.hulai.dushuren.di.scope.ActivityScope;
import com.hulai.dushuren.ui.fragment.Fragment1;
import com.hulai.dushuren.ui.fragment.Fragment2;
import com.hulai.dushuren.ui.fragment.Fragment3;
import com.hulai.dushuren.ui.fragment.Fragment4;

import dagger.Module;
import dagger.Provides;

/**
 * 作者:shiyuzhe on 2018/7/2 18:04
 * 邮箱:18091664559@163.com
 * Desc:
 */
@Module
public class ActHomeModule {

    @Provides
    @ActivityScope
    static Teacher provideTeacher() {
        return new Teacher();
    }

//    @Provides
//    static Fragment1 provideFragment1() {
//        return Fragment1.getInstance();
//    }
//
//    @Provides
//    static Fragment2 provideFragment2() {
//        return Fragment2.getInstance();
//    }
//
//    @Provides
//    static Fragment3 provideFragment3() {
//        return Fragment3.getInstance();
//    }
//
//    @Provides
//    static Fragment4 provideFragment4() {
//        return Fragment4.getInstance();
//    }
}
