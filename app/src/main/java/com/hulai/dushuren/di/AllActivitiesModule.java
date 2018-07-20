package com.hulai.dushuren.di;


import com.hulai.dushuren.ui.activity.ActHome;
import com.hulai.dushuren.ui.activity.ActTab;
import com.hulai.dushuren.ui.activity.ActView;
import com.hulai.dushuren.di.module.ActHomeModule;
import com.hulai.dushuren.di.module.MainActivityModule;
import com.hulai.dushuren.di.module.SecondActivityModule;
import com.hulai.dushuren.di.scope.ActivityScope;
import com.hulai.dushuren.ui.activity.MainActivity;
import com.hulai.dushuren.ui.activity.SecondActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AllActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivitytInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = SecondActivityModule.class)
    abstract SecondActivity contributeSecondActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = ActHomeModule.class)
    abstract ActHome contributeActHomeInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = ActHomeModule.class)
    abstract ActView contributeActViewInjector();
    @ActivityScope
    @ContributesAndroidInjector(modules = ActHomeModule.class)
    abstract ActTab contributeActTabInjector();
}
