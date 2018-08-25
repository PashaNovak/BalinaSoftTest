package com.novakpavel.balinasofttest.mvp.model.interactor.implementations;

import android.annotation.SuppressLint;

import com.novakpavel.balinasofttest.R;
import com.novakpavel.balinasofttest.mvp.model.interactor.interfaces.IAuthInteractor;
import com.novakpavel.balinasofttest.mvp.model.repository.interfaces.IAuthRepository;
import com.novakpavel.balinasofttest.utils.DnsUtil;
import com.novakpavel.balinasofttest.utils.ValidationUtil;
import com.novakpavel.balinasofttest.utils.exception.BalinaSoftTestException;
import com.novakpavel.balinasofttest.utils.exception.ErrorHandlingUtil;

import javax.inject.Inject;

import io.reactivex.Single;

public class AuthInteractorImpl implements IAuthInteractor {

    private final IAuthRepository mAuthRepository;

    @Inject
    public AuthInteractorImpl(IAuthRepository mAuthRepository) {
        this.mAuthRepository = mAuthRepository;
    }

    @SuppressLint("CheckResult")
    @Override
    public Single<Boolean> validationResponse(String userEmail, String userPassword) {
        if (!ValidationUtil.isEmailEmpty(userEmail)) {
            if (ValidationUtil.isEmailValid(userEmail)) {
                return mAuthRepository.getDnsResponse(DnsUtil.getEmailDns(userEmail))
                        .flatMap(dnsResponse -> {
                            if (dnsResponse.getAnswer() == null) {
                                return Single.error(new BalinaSoftTestException(R.string.email_contains_not_right_domain));
                            } else {
                                if (!ValidationUtil.isPasswordEmpty(userPassword)) {
                                    if (ValidationUtil.isPasswordValid(userPassword)) {
                                        return Single.just(true);
                                    } else
                                        return Single.error(new BalinaSoftTestException(R.string.password_is_not_valid));
                                } else
                                    return Single.error(new BalinaSoftTestException(R.string.password_is_empty));
                            }
                        })
                        .onErrorResumeNext(ErrorHandlingUtil::defaultHandle);
            } else
                return Single.error(new BalinaSoftTestException(R.string.email_has_incorrect_format));
        } else return Single.error(new BalinaSoftTestException(R.string.email_is_empty));
    }
}
