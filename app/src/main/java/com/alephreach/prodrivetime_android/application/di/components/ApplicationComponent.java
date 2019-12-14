package com.alephreach.prodrivetime_android.application.di.components;

import com.alephreach.prodrivetime_android.application.di.modules.ApplicationModule;
import com.alephreach.prodrivetime_android.networking.pushnotification.FetchFireBaseTokenUseCase;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    FetchUserProfileAndLoginUseCase getFetchUserProfileAndLoginUseCase();
    FetchFireBaseTokenUseCase getFetchFireBaseTokenUseCase();
}
