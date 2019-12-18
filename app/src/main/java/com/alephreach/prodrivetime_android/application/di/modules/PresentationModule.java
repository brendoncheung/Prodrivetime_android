package com.alephreach.prodrivetime_android.application.di.modules;

import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.alephreach.prodrivetime_android.application.di.components.ApplicationComponent;
import com.alephreach.prodrivetime_android.application.di.factory.ViewMvcFactory;
import com.alephreach.prodrivetime_android.authentication.Authenticator;
import com.alephreach.prodrivetime_android.authentication.AuthenticatorImpl;
import com.alephreach.prodrivetime_android.networking.pushnotification.FetchFireBaseTokenUseCase;
import com.alephreach.prodrivetime_android.networking.usecase.FetchJobRequestUseCase;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;
import com.alephreach.prodrivetime_android.scene.common.hostactivity.ProdrivetimeActivityController;
import com.alephreach.prodrivetime_android.scene.common.coordinator.ApplicationCoordinator;
import com.alephreach.prodrivetime_android.scene.login.LoginFragmentController;
import com.alephreach.prodrivetime_android.scene.requests.JobRequestFragmentController;
import com.alephreach.prodrivetime_android.scene.userprofile.UserProfileController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    private final ApplicationComponent mApplicationComponent;
    private final FragmentActivity mFragmentActivity;

    // bootstrapping dependencies
    public PresentationModule(ApplicationComponent applicationComponent,
                              FragmentActivity fragmentActivity){
        mApplicationComponent = applicationComponent;
        mFragmentActivity = fragmentActivity;
    }

    @Singleton
    @Provides
    FetchUserProfileAndLoginUseCase getFetchUserProfileAndLoginUseCase() {
        return mApplicationComponent.getFetchUserProfileAndLoginUseCase();
    }

    @Provides
    FetchFireBaseTokenUseCase getFetchFireBaseTokenUseCase() {
        return mApplicationComponent.getFetchFireBaseTokenUseCase();
    }

     @Provides
    FetchJobRequestUseCase getFetchJobRequestUseCase() {
        return mApplicationComponent.getFetchJobRequestUseCase();
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
        return new ApplicationCoordinator(authenticator, manager);
    }

    @Provides
    ProdrivetimeActivityController getProdrivetimeActivityController(ApplicationCoordinator coordinator,
                                                                     FetchUserProfileAndLoginUseCase fetchUserProfileAndLoginUseCase) {
        return new ProdrivetimeActivityController(coordinator, fetchUserProfileAndLoginUseCase);
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

    @Provides
    UserProfileController getUserProfileController(FetchJobRequestUseCase fetchJobRequestUseCase) {
        return new UserProfileController(fetchJobRequestUseCase);
    }

    @Provides
    JobRequestFragmentController getJobRequestFragmentController(FetchJobRequestUseCase fetchJobRequestUseCase) {
        return new JobRequestFragmentController(fetchJobRequestUseCase, applicationCoordinator);
    }

}





















