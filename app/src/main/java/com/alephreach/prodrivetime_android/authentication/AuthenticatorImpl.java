package com.alephreach.prodrivetime_android.authentication;

import com.alephreach.prodrivetime_android.networking.pushnotification.FetchFireBaseTokenUseCase;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;

import javax.inject.Inject;

public class AuthenticatorImpl implements Authenticator {

//    @Inject FetchUserProfileAndLoginUseCase mFetchUserProfileAndLoginUseCase;
//    @Inject FetchFireBaseTokenUseCase mFetchFireBaseTokenUseCase;
//
//    public AuthenticatorImpl(FetchFireBaseTokenUseCase fetchFireBaseTokenUseCase,
//                             FetchUserProfileAndLoginUseCase userProfileAndLoginUseCase) {
//        mFetchFireBaseTokenUseCase = fetchFireBaseTokenUseCase;
//        mFetchUserProfileAndLoginUseCase = userProfileAndLoginUseCase;
//    }

    @Override
    public boolean shouldAutoLogin() {
        return false;
    }
}
