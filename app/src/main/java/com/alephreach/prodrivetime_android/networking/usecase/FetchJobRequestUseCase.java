package com.alephreach.prodrivetime_android.networking.usecase;

import com.alephreach.prodrivetime_android.application.common.BaseObservableViewMvc;
import com.alephreach.prodrivetime_android.domain.JobRequest;
import com.alephreach.prodrivetime_android.networking.ProdrivetimeApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchJobRequestUseCase extends BaseObservableViewMvc<FetchJobRequestUseCase.Listener> {

    public interface Listener {
        void onJobRequestFetching();
        void onJobRequestFetchedSuccessful(List<JobRequest> requests);
        void onJobRequestFetchedFailed(String msg);
    }

    private final ProdrivetimeApi mProdrivetimeApi;

    public FetchJobRequestUseCase(ProdrivetimeApi prodrivetimeApi) {
        mProdrivetimeApi = prodrivetimeApi;
    }

    public void fetchJobRequestsAndNotify(String driverEmail) {

        notifyStart();

        mProdrivetimeApi.fetchJobRequests(driverEmail).enqueue(new Callback<List<JobRequest>>() {
            @Override
            public void onResponse(Call<List<JobRequest>> call, Response<List<JobRequest>> response) {
                if(response.isSuccessful()) {
                    notifySuccess(response.body());
                } else {
                    notifyFailure(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<JobRequest>> call, Throwable t) {
                notifyFailure(t.toString());
            }
        });
    }

    private void notifyStart() {
        for(Listener listener : getListeners()) {
            listener.onJobRequestFetching();
        }
    }

    private void notifySuccess(List<JobRequest> requests) {
        for(Listener listener : getListeners()) {
            listener.onJobRequestFetchedSuccessful(requests);
        }
    }

    private void notifyFailure(String msg) {
        for(Listener listener : getListeners()) {
            listener.onJobRequestFetchedFailed(msg);
        }
    }
}
