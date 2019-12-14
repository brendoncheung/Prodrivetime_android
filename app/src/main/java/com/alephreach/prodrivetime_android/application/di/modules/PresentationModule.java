package com.alephreach.prodrivetime_android.application.di.modules;

import android.view.LayoutInflater;
import android.widget.ViewSwitcher;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.alephreach.prodrivetime_android.application.di.components.ApplicationComponent;
import com.alephreach.prodrivetime_android.application.di.factory.ViewMvcFactory;
import com.alephreach.prodrivetime_android.authentication.Authenticator;
import com.alephreach.prodrivetime_android.authentication.AuthenticatorImpl;
import com.alephreach.prodrivetime_android.networking.ProdrivetimeApi;
import com.alephreach.prodrivetime_android.networking.pushnotification.FetchFireBaseTokenUseCase;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;
import com.alephreach.prodrivetime_android.scene.common.FragmentFrameWrapper;
import com.alephreach.prodrivetime_android.scene.common.coordinator.ApplicationCoordinator;
import com.alephreach.prodrivetime_android.scene.login.LoginFragmentController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.http.POST;

@Module
public class PresentationModule {

    private final ApplicationComponent mApplicationComponent;
    private final FragmentActivity mFragmentActivity;
    private final FragmentFrameWrapper mWrapper;

    // bootstrapping dependencies
    public PresentationModule(ApplicationComponent applicationComponent,
                              FragmentActivity fragmentActivity,
                              FragmentFrameWrapper fragmentFrameWrapper) {
        mApplicationComponent = applicationComponent;
        mFragmentActivity = fragmentActivity;
        mWrapper = fragmentFrameWrapper;
    }

    @Provides
    FetchUserProfileAndLoginUseCase getFetchUserProfileAndLoginUseCase() {
        return mApplicationComponent.getFetchUserProfileAndLoginUseCase();
    }

    @Provides
    FetchFireBaseTokenUseCase getFetchFireBaseTokenUseCase() {
        return mApplicationComponent.getFetchFireBaseTokenUseCase();
    }

    @Provides
    FragmentManager getFragmentManager() {
        return mFragmentActivity.getSupportFragmentManager();
    }

    @Provides
    LayoutInflater getLayoutInflator() {
        return mFragmentActivity.getLayoutInflater();
    }

    @Provides
    ViewMvcFactory getViewMvcFactory(LayoutInflater layoutInflater) {
        return new ViewMvcFactory(layoutInflater);
    }

    @Provides
    Authenticator getAuthenticator() {
        return new AuthenticatorImpl();
    }

    @Singleton
    @Provides
    ApplicationCoordinator getApplicationCoordinator(Authenticator authenticator,
                                                     FragmentManager manager) {
        return new ApplicationCoordinator(authenticator, manager, mWrapper);
    }

    @Provides
    LoginFragmentController getLoginFragmentController(FetchUserProfileAndLoginUseCase userProfileAndLoginUseCase,
                                                       FetchFireBaseTokenUseCase fireBaseTokenUseCase,
                                                       ApplicationCoordinator coordinator) {
        return new LoginFragmentController(
                userProfileAndLoginUseCase,
                fireBaseTokenUseCase,
                coordinator);
    }

}





















