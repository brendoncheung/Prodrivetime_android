package com.alephreach.prodrivetime_android.scene.userprofile;

import com.alephreach.prodrivetime_android.domain.JobRequest;
import com.alephreach.prodrivetime_android.domain.User;
import com.alephreach.prodrivetime_android.networking.usecase.FetchJobRequestUseCase;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;

import java.util.List;

import javax.inject.Inject;

public class UserProfileController implements FetchJobRequestUseCase.Listener{

    private final FetchJobRequestUseCase mFetchJobRequestUseCase;

    private User mUser;
    private UserProfileViewMvc mViewMvc;

    @Inject
    public UserProfileController(FetchJobRequestUseCase fetchJobRequestUseCase) {
        mFetchJobRequestUseCase = fetchJobRequestUseCase;
    }

    public void bindView(UserProfileViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public void bindUser(User user) {
        mUser = user;
    }

    public void onStart() {
        mFetchJobRequestUseCase.registerListener(this);
        mViewMvc.showUserprofile(mUser);
    }

    public void onStop() {
        mFetchJobRequestUseCase.unregisterListener(this);
    }


    @Override
    public void onJobRequestFetching() {

    }

    @Override
    public void onJobRequestFetchedSuccessful(List<JobRequest> requests) {
        mViewMvc.showNumberOfAvailableJob(requests.size());
    }

    @Override
    public void onJobRequestFetchedFailed(String msg) {

    }
}
