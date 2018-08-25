package com.novakpavel.balinasofttest.utils.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public abstract class KeyboardUtil {

    public static void hideKeyboard(@Nullable Activity activity) {
        if (activity == null) {
            return;
        }
        @Nullable InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        @Nullable View currentFocus = activity.getCurrentFocus();
        if (imm != null && currentFocus != null) {
            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }
}
