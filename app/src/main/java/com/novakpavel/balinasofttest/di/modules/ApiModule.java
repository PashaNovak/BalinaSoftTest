package com.novakpavel.balinasofttest.di.modules;

import com.novakpavel.balinasofttest.mvp.model.repository.ApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    ApiInterface provideDnsInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }
}
