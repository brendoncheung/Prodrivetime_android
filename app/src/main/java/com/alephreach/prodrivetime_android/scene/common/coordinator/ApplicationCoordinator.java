package com.alephreach.prodrivetime_android.scene.common.coordinator;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alephreach.prodrivetime_android.authentication.Authenticator;
import com.alephreach.prodrivetime_android.domain.JobRequest;
import com.alephreach.prodrivetime_android.domain.User;
import com.alephreach.prodrivetime_android.scene.common.wrapper.FragmentFrameWrapper;
import com.alephreach.prodrivetime_android.scene.login.LoginFragment;
import com.alephreach.prodrivetime_android.scene.requests.JobRequestFragment;
import com.alephreach.prodrivetime_android.scene.userprofile.UserProfileFragment;

import java.util.List;

public class ApplicationCoordinator {

    private final FragmentManager mFragmentManager;
    private final Authenticator mAuthenticator;

    private int mFrameId;
    private User mCachedUser;
    private List<JobRequest> mCachedJobRequests;

    public ApplicationCoordinator(Authenticator authenticator,
                                  FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
        mAuthenticator = authenticator;
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
        mCachedUser = user;
        getFragmentTransaction().replace(getFrameId(), UserProfileFragment.newInstance(user)).commit();
    }

    public void pushToUserProfileCached() {
        getFragmentTransaction().replace(getFrameId(), UserProfileFragment.newInstance(mCachedUser)).commit();
    }

    public void pushToJobRequest() {
        getFragmentTransaction().replace(getFrameId(), JobRequestFragment.newInstance(mCachedUser)).commit();
    }

    public void pushToJobRequestDetails(JobRequest request) {

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












