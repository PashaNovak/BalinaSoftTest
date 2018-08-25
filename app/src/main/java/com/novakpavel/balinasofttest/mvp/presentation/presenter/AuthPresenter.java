package com.novakpavel.balinasofttest.mvp.presentation.presenter;

import android.support.annotation.Nullable;

import com.arellomobile.mvp.InjectViewState;
import com.novakpavel.balinasofttest.App;
import com.novakpavel.balinasofttest.mvp.model.interactor.interfaces.IAuthInteractor;
import com.novakpavel.balinasofttest.mvp.presentation.presenter.base.BaseAppPresenter;
import com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.IAuthView;
import com.novakpavel.balinasofttest.utils.exception.BalinaSoftTestException;

import javax.inject.Inject;

import io.reactivex.Single;

@InjectViewState
public class AuthPresenter extends BaseAppPresenter<IAuthView> {

    @Inject
    IAuthInteractor authInteractor;

    public AuthPresenter() {
        App.getAppComponent().inject(this);
    }

    public void registerUser(@Nullable String userEmail, @Nullable String userPassword) {
        addLiteDisposible(authInteractor.validationResponse(userEmail, userPassword)
                .observeOn(mUIScheduler)
                .doOnSuccess(bol -> getViewState().showAutocloseableMessage("Success!"))
                .onErrorResumeNext(throwable -> {
                    if (throwable instanceof BalinaSoftTestException) {
                        getViewState().showErrorMessage(getString(((BalinaSoftTestException) throwable).getStringRes()));
                        return Single.just(true);
                    } else return Single.error(throwable);
                })
                .subscribe());
    }
}
