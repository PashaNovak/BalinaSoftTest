package com.novakpavel.balinasofttest.mvp.model.repository.implementations;

import com.novakpavel.balinasofttest.constants.AppConstants;
import com.novakpavel.balinasofttest.mvp.model.repository.ApiInterface;
import com.novakpavel.balinasofttest.mvp.model.repository.dto.DnsResponse;
import com.novakpavel.balinasofttest.mvp.model.repository.interfaces.IAuthRepository;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class AuthRepositoryImpl implements IAuthRepository {

    private final ApiInterface apiInterface;
    private final Scheduler mIOScheduler;

    @Inject
    public AuthRepositoryImpl(ApiInterface apiInterface,
                              @Named(AppConstants.IO_SCHEDULER) Scheduler mIOScheduler) {
        this.apiInterface = apiInterface;
        this.mIOScheduler = mIOScheduler;
    }

    @Override
    public Single<DnsResponse> getDnsResponse(String emailTopDomain) {
        return apiInterface.getDnsResponse(emailTopDomain)
                .subscribeOn(mIOScheduler);
    }
}
