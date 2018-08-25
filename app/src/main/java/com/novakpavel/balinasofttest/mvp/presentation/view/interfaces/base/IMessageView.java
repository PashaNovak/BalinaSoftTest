package com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.base;

import android.support.annotation.NonNull;

public interface IMessageView {
    void showAutocloseableMessage(@NonNull String message);
    /*void showDialogMessage(@NonNull String message, boolean closeable);
    void showDialogWithOptions(@NonNull String title,
                               @NonNull String message,
                               @Nullable View viewElement,
                               @Nullable String positiveOptionMessage,
                               @Nullable String negativeOptionMessage,
                               @Nullable DialogInterface.OnClickListener positiveActionListener,
                               @Nullable DialogInterface.OnClickListener negativeActionListener,
                               boolean cancelable);
    void hideDialogMessage();*/
    void hideMessage();
    /*void showMessage(@NonNull String message,
                     boolean closeable,
                     @Nullable String actionMessage,
                     @Nullable View.OnClickListener onClickListener);*/
}
