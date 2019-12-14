package com.alephreach.prodrivetime_android.scene.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alephreach.prodrivetime_android.application.di.factory.ViewMvcFactory;
import com.alephreach.prodrivetime_android.scene.common.baseclass.BaseFragment;

import javax.inject.Inject;

public class LoginFragment extends BaseFragment {

    private LoginFragmentViewMvc mViewMvc;
    @Inject LoginFragmentController mLoginFragmentController;
    @Inject ViewMvcFactory mViewMvcFactory;

    public static LoginFragment newInstance() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getPresentationComponent().inject(this);
        mViewMvc = mViewMvcFactory.newInstance(LoginFragmentViewMvc.class, container);
        mLoginFragmentController.bindView(mViewMvc);
        return mViewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mLoginFragmentController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mLoginFragmentController.onStop();
    }
}
