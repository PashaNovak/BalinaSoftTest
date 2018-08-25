package com.novakpavel.balinasofttest.di.modules;

import com.novakpavel.balinasofttest.mvp.model.manager.implementations.ResourcesManagerImpl;
import com.novakpavel.balinasofttest.mvp.model.manager.interfaces.IResourcesManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface ManagerModule {

    @Binds
    @Singleton
    IResourcesManager provideResourcesManager(ResourcesManagerImpl resourcesManager);
}
