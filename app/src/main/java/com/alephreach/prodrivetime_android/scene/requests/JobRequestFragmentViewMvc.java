package com.alephreach.prodrivetime_android.scene.requests;

import com.alephreach.prodrivetime_android.application.common.ObservableViewMvc;
import com.alephreach.prodrivetime_android.domain.JobRequest;

import java.util.List;

public interface JobRequestFragmentViewMvc extends ObservableViewMvc<JobRequestFragmentViewMvc.Listener> {

    public interface Listener {
        void onSwipeDown();
        void onRequestClicked(JobRequest jobRequest);
    }

    void bindRequest(List<JobRequest> jobRequestList);
    void showLoadingIndicator();
    void hideLoadingIndicator();
    void showEmptyState();
    void hideEmptyState();
    void hideSwipeIndicator();


}
