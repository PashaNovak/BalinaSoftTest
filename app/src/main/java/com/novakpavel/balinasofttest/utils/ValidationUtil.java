package com.novakpavel.balinasofttest.utils;

import android.text.TextUtils;

public abstract class ValidationUtil {

    public static boolean isEmailEmpty(String userEmail){
        return TextUtils.isEmpty(userEmail);
    }

    public static boolean isEmailValid(String userEmail){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches();
    }

    public static boolean isPasswordValid(String userPassword){
        return userPassword.length() >= 8 && userPassword.length() <= 30;
    }

    public static boolean isPasswordEmpty(String userPassword){
        return TextUtils.isEmpty(userPassword);
    }
}
