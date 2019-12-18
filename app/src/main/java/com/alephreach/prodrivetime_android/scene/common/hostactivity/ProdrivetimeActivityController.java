package com.alephreach.prodrivetime_android.scene.common.hostactivity;

import android.widget.Toast;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.domain.User;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;
import com.alephreach.prodrivetime_android.scene.common.coordinator.ApplicationCoordinator;

public class ProdrivetimeActivityController implements ProdrivetimeActivityViewMvc.Listener, FetchUserProfileAndLoginUseCase.Listener {

    private final ApplicationCoordinator mApplicationCoordinator;
    private final FetchUserProfileAndLoginUseCase mFetchUserProfileAndLoginUseCase;

    private ProdrivetimeActivityViewMvc mViewMvc;

    public ProdrivetimeActivityController(ApplicationCoordinator coordinator,
                                          FetchUserProfileAndLoginUseCase fetchUserProfileAndLoginUseCase) {
        mApplicationCoordinator = coordinator;
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
                mApplicationCoordinator.pushToUserProfileCached();
                break;

            case R.id.job_request_id:
                mApplicationCoordinator.pushToJobRequest();
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
