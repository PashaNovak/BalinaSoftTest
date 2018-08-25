package com.novakpavel.balinasofttest.mvp.presentation.presenter.base;

import android.support.annotation.Nullable;

import com.novakpavel.balinasofttest.R;
import com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.base.IBaseView;
import com.novakpavel.balinasofttest.utils.AppLog;
import com.novakpavel.balinasofttest.utils.exception.BalinaSoftTestException;

import io.reactivex.functions.Consumer;

public abstract class BaseErrorPresenter<View extends IBaseView> extends BasePresenter<View> implements Consumer<Throwable> {

    @Override
    public final void accept(@Nullable Throwable throwable) {
        if (throwable != null) {
            throwable.printStackTrace();
        }
        AppLog.logPresenter(this, "ERROR_HANDLING", throwable);
        defaultErrorHandling(throwable);
    }

    private void defaultErrorHandling(@Nullable Throwable throwable) {
        AppLog.logPresenter(this, "defaultErrorHandling", throwable);
        getViewState().hideKeyboard();
        if (throwable != null && throwable instanceof BalinaSoftTestException) {
            BalinaSoftTestException balinaSoftTestException = (BalinaSoftTestException) throwable;
            handleException(getString(balinaSoftTestException.getStringRes()));
        } else {
            handleException(getString(R.string.unknown_error));
        }
    }

    private void handleException(String message) {
        getViewState().showAutocloseableMessage(message);
    }
}
