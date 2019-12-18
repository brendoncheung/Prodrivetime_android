package com.alephreach.prodrivetime_android.networking.usecase;

import com.alephreach.prodrivetime_android.application.common.BaseObservableViewMvc;
import com.alephreach.prodrivetime_android.domain.User;
import com.alephreach.prodrivetime_android.networking.ProdrivetimeApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchUserProfileAndLoginUseCase extends BaseObservableViewMvc<FetchUserProfileAndLoginUseCase.Listener> {

    public interface Listener {
        void onLoginInProcess();
        void onLoginFailed(String msg);
        void onLoginSuccessful(User user);
    }

    private final ProdrivetimeApi mProdrivetimeApi;

    public FetchUserProfileAndLoginUseCase(ProdrivetimeApi prodrivetimeApi) {
        this.mProdrivetimeApi = prodrivetimeApi;
    }

    public void FetchUserProfileAndNotify(String email, String password, String token) {

        mProdrivetimeApi.fetchUserProfile(email, password, token).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    User user = response.body();
                    notifySuccess(user);
                } else {
                    notifyFailed(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                notifyFailed(t.toString());
            }
        });
    }

    private void notifySuccess(User user) {
        for(Listener listener : getListeners()) {
            listener.onLoginSuccessful(user);
        }
    }

    private void notifyFailed(String msg) {
        for(Listener listener : getListeners()) {
            listener.onLoginFailed(msg);
        }

    }


}
