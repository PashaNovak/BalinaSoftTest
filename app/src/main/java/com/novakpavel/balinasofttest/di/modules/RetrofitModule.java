package com.novakpavel.balinasofttest.di.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.novakpavel.balinasofttest.BuildConfig;
import com.novakpavel.balinasofttest.constants.AppConstants;
import com.novakpavel.balinasofttest.mvp.model.manager.implementations.network.HeaderInterceptorImpl;
import com.novakpavel.balinasofttest.utils.AppLog;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    Cache provideCache(Context context) {
        File file = new File(context.getCacheDir(), "RESPONSE");
        return new Cache(file, AppConstants.CASH_SIZE);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor((message -> AppLog.logObject(HttpLoggingInterceptor.class, message)));
        httpLoggingInterceptor.
                setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    OkHttpClient okDnsHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                 Cache cache,
                                 HeaderInterceptorImpl headerInterceptor) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(AppConstants.CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(AppConstants.WRITE_CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(AppConstants.READ_CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (BuildConfig.IS_LOG_ENABLED) {
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor);
        }
        okHttpClientBuilder.retryOnConnectionFailure(true);
        okHttpClientBuilder.cache(cache);
        okHttpClientBuilder.addInterceptor(headerInterceptor);
        return okHttpClientBuilder.build();
    }

    @Provides
    @Singleton
    Retrofit provideDnsRetrofit(OkHttpClient okHttpClient,
                                 RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                                 GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .baseUrl(BuildConfig.API_URL)
                .build();
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory rxJava2CallAdapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }
    @Provides
    @Singleton
    GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }
}
