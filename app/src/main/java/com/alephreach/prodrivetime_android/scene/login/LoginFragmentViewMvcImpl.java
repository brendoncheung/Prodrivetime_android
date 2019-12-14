package com.alephreach.prodrivetime_android.scene.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.application.common.BaseObservableViewMvc;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class LoginFragmentViewMvcImpl extends BaseObservableViewMvc<LoginFragmentViewMvc.Listener> implements LoginFragmentViewMvc {

    private TextInputEditText mEditText_Email, mEditText_Password;
    private Button mButton;
    private ProgressBar mProgressBar;

    public LoginFragmentViewMvcImpl(LayoutInflater inflater, ViewGroup viewGroup) {
        setRootView(inflater.inflate(R.layout.fragment_login, viewGroup, false));
        viewInitialization();
    }

    private void viewInitialization() {
        mEditText_Email = findViewById(R.id.login_screen_email_edit_text);
        mEditText_Password = findViewById(R.id.login_screen_password_edit_text);
        mButton = findViewById(R.id.login_screen_button);
        mProgressBar = findViewById(R.id.login_screen_loading_indicator);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Listener listener : getListeners()) {
                    listener.loginButtonClicked();
                }
            }
        });
    }

    @Override
    public void showLoadingIndicator() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showAlertDialog(String title, String description) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setMessage(description)
                .setPositiveButton("Okay", null);

        builder.show();
    }


    @Override
    public Bundle getViewState() {
        Bundle bundle = new Bundle();
        bundle.putString(LoginFragmentViewMvc.EMAIL_KEY, mEditText_Email.getText().toString());
        bundle.putString(LoginFragmentViewMvc.PASSWORD_KEY, mEditText_Password.getText().toString());
        return bundle;
    }
}
