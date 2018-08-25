package com.novakpavel.balinasofttest.mvp.presentation.view.implementations;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.novakpavel.balinasofttest.R;
import com.novakpavel.balinasofttest.mvp.presentation.presenter.SplashPresenter;
import com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.SplashView;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {

    @InjectPresenter
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashPresenter.navigateToAuth();
    }

    @Override
    public void navigateToAuthScreen() {
        AuthActivity.start(this);
    }
}
