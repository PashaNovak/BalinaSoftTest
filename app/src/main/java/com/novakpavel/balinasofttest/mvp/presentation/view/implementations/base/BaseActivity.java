package com.novakpavel.balinasofttest.mvp.presentation.view.implementations.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.novakpavel.balinasofttest.constants.AppConstants;
import com.novakpavel.balinasofttest.mvp.presentation.presenter.base.BaseAppPresenter;
import com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.base.IBaseView;
import com.novakpavel.balinasofttest.utils.AppLog;
import com.novakpavel.balinasofttest.utils.view.KeyboardUtil;
import com.novakpavel.balinasofttest.utils.view.ShowSnackbarUtil;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.reactivex.Scheduler;

public abstract class BaseActivity<P extends BaseAppPresenter> extends MvpAppCompatActivity implements IBaseView {

    @Nullable
    private Snackbar mSnackbar;

    @Inject
    @Named(AppConstants.UI_SCHEDULER)
    protected Scheduler mUIScheduler;

    @Inject
    @Named(AppConstants.IO_SCHEDULER)
    protected Scheduler mIOScheduler;

    @LayoutRes
    public abstract int getLayoutResId();

    @IdRes
    public abstract int getRootViewResId();

    protected abstract P getPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppLog.logActivity(this);
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        getMvpDelegate().onAttach();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getMvpDelegate().onAttach();
    }

    @Override
    protected void onStart() {
        AppLog.logActivity(this);
        super.onStart();
    }

    @Override
    protected void onResume() {
        AppLog.logActivity(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        AppLog.logActivity(this);
        hideKeyboard();
        super.onPause();
    }

    @Override
    protected void onStop() {
        AppLog.logActivity(this);
        hideMessage();
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        getPresenter().onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getPresenter().onActivityResult(requestCode, resultCode, data, this);
    }

    @Override
    public void hideKeyboard() {
        AppLog.logActivity(this);
        KeyboardUtil.hideKeyboard(this);
    }

    @Override
    public void showAutocloseableMessage(@NonNull String message) {
        AppLog.logActivity(this);
        showMessage(message);
    }

    private void showMessage(@NonNull String message) {
        hideMessage();
        hideKeyboard();
        @Nullable View rootView = findViewById(getRootViewResId());
        if (rootView == null)
            rootView = getWindow().getDecorView();
        mSnackbar = ShowSnackbarUtil.showSnackBar(rootView,
                this,
                message,
                BaseTransientBottomBar.LENGTH_SHORT
        );
    }

    @Override
    public void hideMessage() {
        AppLog.logActivity(this);
        if (mSnackbar != null)
            mSnackbar.dismiss();
    }
}
