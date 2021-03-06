package com.alephreach.prodrivetime_android.scene.userprofile;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alephreach.prodrivetime_android.application.di.factory.ViewMvcFactory;
import com.alephreach.prodrivetime_android.domain.User;
import com.alephreach.prodrivetime_android.scene.common.baseclass.BaseFragment;

import org.parceler.Parcels;

import javax.inject.Inject;

public class UserProfileFragment extends BaseFragment {

    public static final String USER_KEY = "USER_KEY";

    private User mUser;

    @Inject UserProfileController mUserProfileController;
    @Inject ViewMvcFactory mViewMvcFactory;

    public static UserProfileFragment newInstance(User user) {
        UserProfileFragment fragment = new UserProfileFragment();
        Parcelable userParcel = Parcels.wrap(user);
        Bundle bundle = new Bundle();
        bundle.putParcelable(USER_KEY, userParcel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mUser = Parcels.unwrap(getArguments().getParcelable(USER_KEY));
        getPresentationComponent().inject(this);
        UserProfileViewMvc viewMvc = mViewMvcFactory.newInstance(UserProfileViewMvc.class, container);
        mUserProfileController.bindUser(mUser);
        mUserProfileController.bindView(viewMvc);
        return mViewMvcFactory.newInstance(UserProfileViewMvc.class, container).getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mUserProfileController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mUserProfileController.onStop();


    }
}
