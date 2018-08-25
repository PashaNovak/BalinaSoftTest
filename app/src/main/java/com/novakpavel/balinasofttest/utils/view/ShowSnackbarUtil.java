package com.novakpavel.balinasofttest.utils.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.novakpavel.balinasofttest.R;

public abstract class ShowSnackbarUtil {

    @Nullable
    public static Snackbar showSnackBar(@Nullable View rootView,
                                        @Nullable Context context,
                                        @NonNull String message,
                                        int duration) {
        if (rootView == null || context == null) {
            return null;
        }

        @Nullable Snackbar snackbar = null;
        try {
            snackbar = Snackbar.make(rootView, message, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (snackbar != null) {
            snackbar.setActionTextColor(ContextCompat.getColor(context, R.color.colorAccent));

            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
            TextView textView = snackBarView.findViewById(R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(context, R.color.color_white));
            snackbar.show();
        }
        return snackbar;
    }
}
