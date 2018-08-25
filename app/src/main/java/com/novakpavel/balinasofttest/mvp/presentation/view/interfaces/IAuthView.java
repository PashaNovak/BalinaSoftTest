package com.novakpavel.balinasofttest.mvp.presentation.view.interfaces;

import android.support.annotation.NonNull;

import com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.base.IBaseView;

public interface IAuthView extends IBaseView {
    void showErrorMessage(@NonNull String errorMessage);
}
