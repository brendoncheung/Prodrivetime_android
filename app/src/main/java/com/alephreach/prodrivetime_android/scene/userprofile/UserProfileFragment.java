package com.alephreach.prodrivetime_android.scene.userprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alephreach.prodrivetime_android.scene.common.baseclass.BaseFragment;

public class UserProfileFragment extends BaseFragment {

    public static UserProfileFragment newInstance() {
        return new UserProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        UserProfileViewMvcImpl viewMvc = new UserProfileViewMvcImpl(inflater, container);
        return viewMvc.getRootView();
    }
}
