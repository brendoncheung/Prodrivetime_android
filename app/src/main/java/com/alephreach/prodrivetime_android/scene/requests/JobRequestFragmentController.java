package com.alephreach.prodrivetime_android.scene.requests;

import com.alephreach.prodrivetime_android.domain.JobRequest;
import com.alephreach.prodrivetime_android.domain.User;
import com.alephreach.prodrivetime_android.networking.usecase.FetchJobRequestUseCase;
import com.alephreach.prodrivetime_android.scene.common.coordinator.ApplicationCoordinatorImpl;

import java.util.List;

import javax.inject.Inject;

public class JobRequestFragmentController implements FetchJobRequestUseCase.Listener, JobRequestFragmentViewMvc.Listener {

    private final FetchJobRequestUseCase mFetchJobRequestUseCase;
    private final ApplicationCoordinatorImpl mApplicationCoordinatorImpl;

    private User mUser;
    private JobRequestFragmentViewMvc mViewMvc;

    @Inject
    public JobRequestFragmentController(FetchJobRequestUseCase fetchJobRequestUseCase, ApplicationCoordinatorImpl applicationCoordinatorImpl) {
        mFetchJobRequestUseCase = fetchJobRequestUseCase;
        mApplicationCoordinatorImpl = applicationCoordinatorImpl;
    }

    public void onStart() {
        mFetchJobRequestUseCase.registerListener(this);
        mViewMvc.registerListener(this);
        startFetchingJobRequests();
    }

    public void onStop() {
        mFetchJobRequestUseCase.unregisterListener(this);
        mViewMvc.unregisterListener(this);
    }

    public void bindUser(User user) {
        mUser = user;
    }

    public void bindView(JobRequestFragmentViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    private void startFetchingJobRequests() {
        mFetchJobRequestUseCase.fetchJobRequestsAndNotify(mUser.email);
    }

    @Override
    public void onJobRequestFetching() {

    }

    @Override
    public void onJobRequestFetchedSuccessful(List<JobRequest> requests) {
        mViewMvc.bindRequest(requests);
    }

    @Override
    public void onJobRequestFetchedFailed(String msg) {
    }

    @Override
    public void onSwipeDown() {

    }

    @Override
    public void onRequestClicked(JobRequest jobRequest) {
        mApplicationCoordinatorImpl.pushToJobRequestDetails(jobRequest);
    }
}
