package com.novakpavel.balinasofttest.di.modules;

import com.novakpavel.balinasofttest.di.annotations.ActivityScope;
import com.novakpavel.balinasofttest.mvp.presentation.view.implementations.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public interface AppActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {ActivityModule.class})
    AuthActivity authActivityInjector();
}
