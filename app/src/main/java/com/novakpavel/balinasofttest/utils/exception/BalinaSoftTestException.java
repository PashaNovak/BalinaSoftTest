package com.novakpavel.balinasofttest.utils.exception;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

public class BalinaSoftTestException extends Exception {
    @NonNull
    @StringRes
    private final Integer stringRes;

    public BalinaSoftTestException(@NonNull Integer stringRes) {
        this.stringRes = stringRes;
    }

    @NonNull
    public Integer getStringRes() {
        return stringRes;
    }
}
