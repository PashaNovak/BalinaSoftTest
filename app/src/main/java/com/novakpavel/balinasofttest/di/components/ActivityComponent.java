package com.novakpavel.balinasofttest.di.components;

import com.novakpavel.balinasofttest.di.annotations.ActivityScope;
import com.novakpavel.balinasofttest.di.modules.ActivityModule;

import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {AppComponent.class})
interface ActivityComponent {
}
