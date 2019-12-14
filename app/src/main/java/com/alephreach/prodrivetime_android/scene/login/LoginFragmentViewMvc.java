package com.alephreach.prodrivetime_android.scene.login;

import android.os.Bundle;

import com.alephreach.prodrivetime_android.application.common.ObservableViewMvc;
import com.alephreach.prodrivetime_android.application.common.ViewMvc;

public interface LoginFragmentViewMvc extends ObservableViewMvc<LoginFragmentViewMvc.Listener> {

    public static final String EMAIL_KEY = "EMAIL";
    public static final String PASSWORD_KEY = "PASSWORD";

    public interface Listener {
        void loginButtonClicked();
    }

    void showLoadingIndicator();
    void hideLoadingIndicator();
    void showAlertDialog(String title, String description);
    Bundle getViewState();
}
