package com.alephreach.prodrivetime_android.scene.requests.details;

import com.alephreach.prodrivetime_android.application.common.ObservableViewMvc;

public interface JobRequestDetailViewMvc extends ObservableViewMvc<JobRequestDetailViewMvc.Listener> {

    public interface Listener {
        void onCallButtonClicked();
        void onAcceptButtonClicked();
    }

    void bindRequestDetail();
}
