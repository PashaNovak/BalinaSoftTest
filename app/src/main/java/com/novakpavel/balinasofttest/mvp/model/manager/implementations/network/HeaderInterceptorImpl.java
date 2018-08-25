package com.novakpavel.balinasofttest.mvp.model.manager.implementations.network;

import android.support.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptorImpl implements Interceptor {

    @Inject
    public HeaderInterceptorImpl() {

    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder mBuilder = originalRequest.newBuilder();

        mBuilder.header("Content-type", "application/json");
        return chain.proceed(mBuilder.build());
    }
}
