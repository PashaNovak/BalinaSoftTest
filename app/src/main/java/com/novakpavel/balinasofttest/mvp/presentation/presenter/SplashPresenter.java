package com.novakpavel.balinasofttest.mvp.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.novakpavel.balinasofttest.constants.AppConstants;
import com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.SplashView;

import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    private PublishSubject<Integer> subject = PublishSubject.create();
    private Disposable disposable = subject.delay(AppConstants.DELAY_SPLASH, TimeUnit.SECONDS)
            .subscribe(integer -> getViewState().navigateToAuthScreen());

    public void navigateToAuth() {
        subject.onNext(1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
