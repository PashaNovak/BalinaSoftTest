package com.novakpavel.balinasofttest.di.modules;

import com.novakpavel.balinasofttest.constants.AppConstants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class SchedulersModule {

    @Provides
    @Singleton
    @Named(AppConstants.IO_SCHEDULER)
    Scheduler provideIOScheduler(){
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named(AppConstants.UI_SCHEDULER)
    Scheduler provideUIScheduler(){
        return AndroidSchedulers.mainThread();
    }
}
