package com.novakpavel.balinasofttest.utils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.novakpavel.balinasofttest.mvp.presentation.presenter.base.BasePresenter;

import com.novakpavel.balinasofttest.BuildConfig;

public abstract class AppLog {

    private static final String APP_TAG = "BALINASOFTTEST_TAG";

    private static boolean isLogEnabled() {
        return BuildConfig.DEBUG;
    }

    private static String getMethodName() {
        try {
            return Thread.currentThread().getStackTrace()[5].getMethodName();
        } catch (Exception e) {
            return "Unknown method";
        }
    }

    private static String getClassName(Object o) {
        return o.getClass().getSimpleName();
    }

    private static String getInfo(Object o) {
        return getClassName(o) + "." + getMethodName();
    }

    private static String getAppTeg() {
        return APP_TAG;
    }

    public static void logActivity(@NonNull Activity activity) {
        if (isLogEnabled()) {
            Log.i(getAppTeg(), getInfo(activity));
        }
    }

    public static void logObject(Class clazz, @Nullable String message) {
        if (isLogEnabled()) {
            Log.i(getAppTeg(), clazz.getSimpleName() + "." + getMethodName() + " " + createMessage(message));
        }
    }

    public static void logPresenter(@NonNull BasePresenter presenter) {
        if (isLogEnabled()) {
            Log.i(getAppTeg(), getInfo(presenter));
        }
    }

    public static void logPresenter(@NonNull BasePresenter presenter,
                                    @Nullable String message,
                                    @Nullable Throwable throwable) {
        if (isLogEnabled()) {
            Log.i(getAppTeg(), getInfo(presenter) + createMessageFromThrowableAndMessage(message, throwable));
        }
    }

    @NonNull
    private static String createMessageFromThrowableAndMessage(@Nullable String message, @Nullable Throwable throwable) {
        return " " + createMessage(message) + " " + createMessageFromThrowable(throwable);
    }

    @NonNull
    private static String createMessageFromThrowable(@Nullable Throwable throwable) {
        return throwable != null
                ? (throwable.getClass().getName() + " " + createMessage(throwable.getMessage()))
                : "nullable_throwable";
    }

    @NonNull
    private static String createMessage(@Nullable String message) {
        return !TextUtils.isEmpty(message) ? message : "unknownMessage";
    }
}
