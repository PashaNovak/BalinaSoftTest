package com.novakpavel.balinasofttest.mvp.model.manager.implementations;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.novakpavel.balinasofttest.mvp.model.manager.interfaces.IResourcesManager;

import javax.inject.Inject;

public class ResourcesManagerImpl implements IResourcesManager {

    @NonNull
    private final Context mAppContext;

    @Inject
    public ResourcesManagerImpl(@NonNull Context mAppContext) {
        this.mAppContext = mAppContext;
    }

    @NonNull
    @Override
    public String getString(int stringResId) {
        @Nullable
        String string = null;
        try {
            string = mAppContext.getString(stringResId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string != null ? string : "";
    }

    @NonNull
    @Override
    public String getString(@StringRes int resId, @NonNull Object... formatArgs) {
        @Nullable
        String string = null;
        try {
            string = mAppContext.getString(resId, formatArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string != null ? string : "";
    }
}
