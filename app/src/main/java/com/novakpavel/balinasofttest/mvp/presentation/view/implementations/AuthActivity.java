package com.novakpavel.balinasofttest.mvp.presentation.view.implementations;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.novakpavel.balinasofttest.R;
import com.novakpavel.balinasofttest.mvp.presentation.presenter.AuthPresenter;
import com.novakpavel.balinasofttest.mvp.presentation.view.implementations.base.BaseActivity;
import com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.IAuthView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class AuthActivity extends BaseActivity<AuthPresenter> implements IAuthView {

    @InjectPresenter
    AuthPresenter mAuthPresenter;

    @BindView(R.id.email_actv)
    AutoCompleteTextView email;

    @BindView(R.id.password_et)
    EditText password;

    @BindView(R.id.error_validation_tv)
    TextView error;

    @OnClick(R.id.reg_btn)
    void registerUser() {
        mAuthPresenter.registerUser(email.getText().toString(), password.getText().toString());
    }

    private ArrayList<String> mDomains;
    private String[] pDomains;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDomains = new ArrayList<>();
        pDomains = getResources().getStringArray(R.array.popular_domains);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputString = s.toString();
                mDomains.clear();
                if (inputString.contains("@")) {
                    String requiredString = inputString.substring(0, inputString.indexOf("@"));
                    for (String pDomain : pDomains) {
                        mDomains.add(requiredString + pDomain);
                    }
                    adapter = new ArrayAdapter<>(AuthActivity.this, android.R.layout.simple_list_item_1, mDomains);
                    email.showDropDown();
                    email.setThreshold(0);
                    email.setAdapter(adapter);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public static void start(@Nullable Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, AuthActivity.class));
        }
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_auth;
    }

    @Override
    public int getRootViewResId() {
        return R.id.r_auth_activity;
    }

    @Override
    protected AuthPresenter getPresenter() {
        return mAuthPresenter;
    }

    @Override
    public void showErrorMessage(@NonNull String errorMessage) {
        error.setText(errorMessage);
        error.setVisibility(View.VISIBLE);
    }
}
