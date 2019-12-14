package com.alephreach.prodrivetime_android.scene.common.coordinator;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alephreach.prodrivetime_android.authentication.Authenticator;
import com.alephreach.prodrivetime_android.domain.data.User;
import com.alephreach.prodrivetime_android.scene.common.FragmentFrameWrapper;
import com.alephreach.prodrivetime_android.scene.login.LoginFragment;
import com.alephreach.prodrivetime_android.scene.userprofile.UserProfileFragment;

public class ApplicationCoordinator {

    private final FragmentManager mFragmentManager;
    private final Authenticator mAuthenticator;
    private final FragmentFrameWrapper mFragmentFrameWrapper;

    private int mFrameId;

    public ApplicationCoordinator(Authenticator authenticator,
                                  FragmentManager fragmentManager,
                                  FragmentFrameWrapper wrapper) {
        mFragmentManager = fragmentManager;
        mAuthenticator = authenticator;
        mFragmentFrameWrapper = wrapper;
    }

    public void bindFragmentFrame(int id) {
        mFrameId = id;
    }

    public void onStart() {

        if(mAuthenticator.shouldAutoLogin()) {
            pushToUserProfile(null);
        } else {
            pushToLoginFragment();
        }
    }

    public void pushToLoginFragment() {
        getFragmentTransaction().add(getFrameId(), LoginFragment.newInstance()).commit();
    }

    public void pushToUserProfile(User user) {
        getFragmentTransaction().replace(getFrameId(), UserProfileFragment.newInstance()).commit();
    }

    private FragmentTransaction getFragmentTransaction() {
        return getFragmentManager().beginTransaction();
    }

    private FragmentManager getFragmentManager() {
        return mFragmentManager;
    }

    private int getFrameId() {
        return mFrameId;
    }
}












