package com.novakpavel.balinasofttest.mvp.presentation.presenter.base;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpPresenter;
import com.novakpavel.balinasofttest.constants.AppConstants;
import com.novakpavel.balinasofttest.mvp.model.manager.interfaces.IResourcesManager;
import com.novakpavel.balinasofttest.mvp.presentation.view.implementations.base.BaseActivity;
import com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.base.IBaseView;
import com.novakpavel.balinasofttest.utils.AppLog;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends IBaseView> extends MvpPresenter<V> {

    private final CompositeDisposable mLite = new CompositeDisposable();

    @Inject
    @Named(AppConstants.UI_SCHEDULER)
    protected Scheduler mUIScheduler;

    @Inject
    @Named(AppConstants.IO_SCHEDULER)
    protected Scheduler mIOScheduler;

    @Inject
    IResourcesManager mResourcesManager;

    @Override
    public void attachView(V view) {
        AppLog.logPresenter(this);
        super.attachView(view);
    }

    @Override
    protected void onFirstViewAttach() {
        AppLog.logPresenter(this);
        super.onFirstViewAttach();
    }

    @Override
    public void detachView(V view) {
        AppLog.logPresenter(this);
        super.detachView(view);
    }

    @Override
    public void destroyView(V view) {
        AppLog.logPresenter(this);
        super.destroyView(view);
    }

    @Override
    public void onDestroy() {
        AppLog.logPresenter(this);
        super.onDestroy();
    }

    protected void addLiteDisposible(@Nullable Disposable disposable) {
        AppLog.logPresenter(this);
        if (disposable != null)
            mLite.add(disposable);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data, @NonNull BaseActivity baseActivity) {
        AppLog.logPresenter(this);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults, @NonNull BaseActivity baseActivity) {
        AppLog.logPresenter(this);
    }

    protected String getString(@StringRes int stringId) {
        return mResourcesManager.getString(stringId);
    }
}
