package com.novakpavel.balinasofttest.mvp.model.manager.interfaces;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

public interface IResourcesManager {
    @NonNull String getString(@StringRes int stringResId);
    @NonNull String getString(@StringRes int stringResId, @NonNull Object... formatArgs);
}
