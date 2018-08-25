package com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.base;

import com.arellomobile.mvp.MvpView;

public interface IBaseView extends IMessageView, MvpView {
    void hideKeyboard();
}
