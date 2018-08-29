package com.novakpavel.balinasofttest.mvp.presentation.view.implementations;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.novakpavel.balinasofttest.R;
import com.novakpavel.balinasofttest.mvp.presentation.presenter.AuthPresenter;
import com.novakpavel.balinasofttest.mvp.presentation.view.implementations.base.BaseActivity;
import com.novakpavel.balinasofttest.mvp.presentation.view.interfaces.IAuthView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;

public class AuthActivity extends BaseActivity<AuthPresenter> implements IAuthView {

    @InjectPresenter
    AuthPresenter mAuthPresenter;

    @BindView(R.id.imageView)
    ImageView logo;

    @BindView(R.id.email_actv)
    AutoCompleteTextView email;

    @OnEditorAction(R.id.email_actv)
    boolean onEmailEditorAction(int actionId) {
        if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_NULL) {
            email.requestFocus();
        }
        return false;
    }

    @BindView(R.id.password_et)
    EditText password;

    @BindView(R.id.error_validation_tv)
    TextView error;

    @OnClick(R.id.reg_btn)
    void registerUser() {
        mAuthPresenter.registerUser(email.getText().toString(), password.getText().toString());
    }

    @OnEditorAction(R.id.password_et)
    boolean onPasswordEditorAction(int actionId) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
            hideKeyboard();
            return true;
        }
        return false;
    }

    private ArrayList<String> mDomains;
    private String[] pDomains;

    @OnTextChanged(value = R.id.email_actv,
    callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onEmailTextChanged(CharSequence s){
        String inputString = s.toString();
        mDomains.clear();
        if (inputString.contains("@")) {
            String requiredString = inputString.substring(0, inputString.indexOf("@"));
            for (String pDomain : pDomains) {
                mDomains.add(requiredString + pDomain);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthActivity.this, android.R.layout.simple_list_item_1, mDomains);
            email.showDropDown();
            email.setThreshold(0);
            email.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDomains = new ArrayList<>();
        pDomains = getResources().getStringArray(R.array.popular_domains);
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

    @Override
    public void hideErrorMessage() {
        error.setVisibility(View.GONE);
    }
}
