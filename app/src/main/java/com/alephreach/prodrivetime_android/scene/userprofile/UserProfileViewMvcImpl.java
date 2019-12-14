package com.alephreach.prodrivetime_android.scene.userprofile;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.application.common.BaseViewMvc;
import com.alephreach.prodrivetime_android.domain.data.User;

class UserProfileViewMvcImpl extends BaseViewMvc implements UserProfileViewMvc {




    public UserProfileViewMvcImpl(LayoutInflater inflater, ViewGroup viewGroup) {
        setRootView(inflater.inflate(R.layout.fragment_user_profile, viewGroup, false));
    }



    @Override
    public void showUserprofile(User user) {

    }
}
