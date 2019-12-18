package com.alephreach.prodrivetime_android.scene.common.hostactivity;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.domain.User;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;
import com.alephreach.prodrivetime_android.scene.common.coordinator.ApplicationCoordinatorImpl;

public class ProdrivetimeActivityController implements ProdrivetimeActivityViewMvc.Listener, FetchUserProfileAndLoginUseCase.Listener {

    private final ApplicationCoordinatorImpl mApplicationCoordinatorImpl;
    private final FetchUserProfileAndLoginUseCase mFetchUserProfileAndLoginUseCase;

    private ProdrivetimeActivityViewMvc mViewMvc;

    public ProdrivetimeActivityController(ApplicationCoordinatorImpl coordinator,
                                          FetchUserProfileAndLoginUseCase fetchUserProfileAndLoginUseCase) {
        mApplicationCoordinatorImpl = coordinator;
        mFetchUserProfileAndLoginUseCase = fetchUserProfileAndLoginUseCase;
    }

    public void onStart() {
        mFetchUserProfileAndLoginUseCase.registerListener(this);
        mViewMvc.registerListener(this);
    }

    public void onStop() {
        mFetchUserProfileAndLoginUseCase.unregisterListener(this);
        mViewMvc.unregisterListener(this);
    }

    public void bindView(ProdrivetimeActivityViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    @Override
    public void onNavigationItemClicked(int id) {

        switch (id) {

            case R.id.profile_id:
                mApplicationCoordinatorImpl.pushToUserProfileCached();
                break;

            case R.id.job_request_id:
                mApplicationCoordinatorImpl.pushToJobRequest();
                break;

        }

        mViewMvc.closeNavigationDrawer();
    }

    @Override
    public void onLoginInProcess() {

    }

    @Override
    public void onLoginFailed(String msg) {

    }

    @Override
    public void onLoginSuccessful(User user) {
        mViewMvc.bindNavigationHeader(user.getName(), user.getDriverId());
    }
}
