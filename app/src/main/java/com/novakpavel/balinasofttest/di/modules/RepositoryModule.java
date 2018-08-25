package com.novakpavel.balinasofttest.di.modules;

import com.novakpavel.balinasofttest.mvp.model.repository.implementations.AuthRepositoryImpl;
import com.novakpavel.balinasofttest.mvp.model.repository.interfaces.IAuthRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface RepositoryModule {

    @Binds
    @Singleton
    IAuthRepository provideAuthRepository(AuthRepositoryImpl authRepository);
}
