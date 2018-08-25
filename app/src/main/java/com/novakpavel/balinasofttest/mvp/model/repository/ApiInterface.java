package com.novakpavel.balinasofttest.mvp.model.repository;

import com.novakpavel.balinasofttest.mvp.model.repository.dto.DnsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("resolve")
    Single<DnsResponse> getDnsResponse(@Query("name") String domainName);
}
