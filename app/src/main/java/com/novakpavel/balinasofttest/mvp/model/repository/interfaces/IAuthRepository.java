package com.novakpavel.balinasofttest.mvp.model.repository.interfaces;

import com.novakpavel.balinasofttest.mvp.model.repository.dto.DnsResponse;

import io.reactivex.Single;

public interface IAuthRepository {

    Single<DnsResponse> getDnsResponse(String emailTopDomain);
}
