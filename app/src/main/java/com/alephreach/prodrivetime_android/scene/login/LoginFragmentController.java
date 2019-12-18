package com.alephreach.prodrivetime_android.scene.login;

import android.os.Bundle;
import android.text.TextUtils;

import com.alephreach.prodrivetime_android.application.common.BaseController;
import com.alephreach.prodrivetime_android.domain.User;
import com.alephreach.prodrivetime_android.networking.pushnotification.FetchFireBaseTokenUseCase;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;
import com.alephreach.prodrivetime_android.scene.common.coordinator.ApplicationCoordinatorImpl;

import javax.inject.Inject;

public class LoginFragmentController implements BaseController,
        LoginFragmentViewMvc.Listener,
        FetchFireBaseTokenUseCase.Listener,
        FetchUserProfileAndLoginUseCase.Listener{

    private LoginFragmentViewMvc mViewMvc;

    private final FetchUserProfileAndLoginUseCase mFetchUserProfileAndLoginUseCase;
    private final FetchFireBaseTokenUseCase mFetchFireBaseTokenUseCase;
    private final ApplicationCoordinatorImpl mApplicationCoordinatorImpl;

    @Inject
    public LoginFragmentController(FetchUserProfileAndLoginUseCase fetchUserProfileAndLoginUseCase,
                                   FetchFireBaseTokenUseCase fetchFireBaseTokenUseCase,
                                   ApplicationCoordinatorImpl coordinator) {
        mFetchUserProfileAndLoginUseCase = fetchUserProfileAndLoginUseCase;
        mFetchFireBaseTokenUseCase = fetchFireBaseTokenUseCase;
        mApplicationCoordinatorImpl = coordinator;
    }

    public void bindView(LoginFragmentViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    @Override
    public void loginButtonClicked() {
        mViewMvc.showLoadingIndicator();
        initializeLoginWorkflow();
    }

    private void initializeLoginWorkflow() {
        if (TextUtils.isEmpty(getEmailFromView()) || TextUtils.isEmpty(getPasswordFromView())) {
            mViewMvc.showAlertDialog("Error", "Please complete login details");
            mViewMvc.hideLoadingIndicator();
            return;
        }
        mFetchFireBaseTokenUseCase.FetchFirebaseTokenAndNotify();
    }

    private String getEmailFromView() {
        Bundle bundle = mViewMvc.getViewState();
        return bundle.getString(LoginFragmentViewMvc.EMAIL_KEY);
    }

    private String getPasswordFromView() {
        Bundle bundle = mViewMvc.getViewState();
        return bundle.getString(LoginFragmentViewMvc.PASSWORD_KEY);
    }

    @Override
    public void onStart() {
        mViewMvc.registerListener(this);
        mFetchUserProfileAndLoginUseCase.registerListener(this);
        mFetchFireBaseTokenUseCase.registerListener(this);
    }

    @Override
    public void onStop() {
        mViewMvc.unregisterListener(this);
        mFetchUserProfileAndLoginUseCase.unregisterListener(this);
        mFetchFireBaseTokenUseCase.unregisterListener(this);
    }

    //<editor-fold desc="firebase callback">
    @Override
    public void firebaseTokenFetched(String token) {
        mFetchUserProfileAndLoginUseCase.FetchUserProfileAndNotify(
                getEmailFromView(),
                getPasswordFromView(),
                token);
    }

    @Override
    public void firebaseTokenFetchedFailed() {
        mViewMvc.hideLoadingIndicator();
        mViewMvc.showAlertDialog("Firebase error", "Unable to fetch firebase token");
    }
    //</editor-fold>

    //<editor-fold desc="login callback">
    @Override
    public void onLoginInProcess() {

    }

    @Override
    public void onLoginFailed(String msg) {
        mViewMvc.hideLoadingIndicator();
        mViewMvc.showAlertDialog("Technical error", "Please check your email/password");
    }

    @Override
    public void onLoginSuccessful(User user) {
        mViewMvc.hideLoadingIndicator();
        mApplicationCoordinatorImpl.pushToUserProfile(user);
    }
    //</editor-fold>

}




















