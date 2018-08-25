package com.novakpavel.balinasofttest.mvp.model.interactor.interfaces;

import io.reactivex.Single;

public interface IAuthInteractor {

    Single<Boolean> validationResponse(String userEmail, String userPassword);
}
