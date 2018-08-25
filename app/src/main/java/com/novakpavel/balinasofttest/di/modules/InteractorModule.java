package com.novakpavel.balinasofttest.di.modules;

import com.novakpavel.balinasofttest.mvp.model.interactor.implementations.AuthInteractorImpl;
import com.novakpavel.balinasofttest.mvp.model.interactor.interfaces.IAuthInteractor;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface InteractorModule {

    @Binds
    @Singleton
    IAuthInteractor provideAuthInteractor(AuthInteractorImpl authInteractor);
}
