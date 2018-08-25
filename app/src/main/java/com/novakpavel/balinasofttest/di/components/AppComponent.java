package com.novakpavel.balinasofttest.di.components;

import com.novakpavel.balinasofttest.App;
import com.novakpavel.balinasofttest.di.modules.ApiModule;
import com.novakpavel.balinasofttest.di.modules.AppActivityModule;
import com.novakpavel.balinasofttest.di.modules.ApplicationModule;
import com.novakpavel.balinasofttest.di.modules.InteractorModule;
import com.novakpavel.balinasofttest.di.modules.ManagerModule;
import com.novakpavel.balinasofttest.di.modules.ParseModule;
import com.novakpavel.balinasofttest.di.modules.RepositoryModule;
import com.novakpavel.balinasofttest.di.modules.RetrofitModule;
import com.novakpavel.balinasofttest.di.modules.SchedulersModule;
import com.novakpavel.balinasofttest.mvp.presentation.presenter.AuthPresenter;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppActivityModule.class,
        ApplicationModule.class,
        InteractorModule.class,
        RepositoryModule.class,
        ManagerModule.class,
        RetrofitModule.class,
        ApiModule.class,
        SchedulersModule.class,
        ParseModule.class
})
public interface AppComponent {

    void inject(App app);
    void inject(AuthPresenter authPresenter);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder appContext(App app);

        AppComponent build();
    }
}
