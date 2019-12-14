package com.alephreach.prodrivetime_android.networking.pushnotification;

import androidx.annotation.NonNull;

import com.alephreach.prodrivetime_android.application.common.BaseObservableViewMvc;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FetchFireBaseTokenUseCase extends BaseObservableViewMvc<FetchFireBaseTokenUseCase.Listener> {

    public interface Listener {
        void firebaseTokenFetched(String token);
        void firebaseTokenFetchedFailed();
    }

    public void FetchFirebaseTokenAndNotify() {

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (task.isSuccessful()) {
                            notifySuccess(task.getResult().getToken());
                        } else if (task.isCanceled()) {
                            notifyFailed();
                        }
                    }
                });
    }

    private void notifySuccess(String token) {
        for(Listener listener: getListeners()) {
            listener.firebaseTokenFetched(token);
        }
    }

    private void notifyFailed() {
        for(Listener listener: getListeners()) {
            listener.firebaseTokenFetchedFailed();
        }
    }


}
