package com.novakpavel.balinasofttest.di.modules;

import android.content.Context;

import com.novakpavel.balinasofttest.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    Context provideContext(App app){
        return app.getApplicationContext();
    }
}
