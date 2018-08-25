package com.novakpavel.balinasofttest.utils;

public abstract class DnsUtil {

    public static String getEmailDns(String userEmail){
        return userEmail.substring(userEmail.indexOf('@')+1);
    }
}
