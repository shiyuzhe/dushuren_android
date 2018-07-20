package com.hulai.dushuren.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by QingMei on 2017/6/15.
 * desc:@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
