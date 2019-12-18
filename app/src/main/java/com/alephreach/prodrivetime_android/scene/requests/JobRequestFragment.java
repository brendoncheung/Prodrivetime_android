package com.alephreach.prodrivetime_android.scene.requests;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alephreach.prodrivetime_android.application.di.factory.ViewMvcFactory;
import com.alephreach.prodrivetime_android.domain.JobRequest;
import com.alephreach.prodrivetime_android.domain.User;
import com.alephreach.prodrivetime_android.scene.common.baseclass.BaseFragment;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

public class JobRequestFragment extends BaseFragment {

    public static final String USER_KEY = "USER_KEY";

    private User mUser;

    public static JobRequestFragment newInstance(User user) {
        JobRequestFragment fragment = new JobRequestFragment();

        Bundle bundle = new Bundle();
        Parcelable userParcel = Parcels.wrap(user);
        bundle.putParcelable(USER_KEY, userParcel);
        fragment.setArguments(bundle);
        return fragment;
    }

    private JobRequestFragmentViewMvc mViewMvc;
    @Inject JobRequestFragmentController mJobRequestFragmentController;
    @Inject ViewMvcFactory mViewMvcFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getPresentationComponent().inject(this);

        mViewMvc = mViewMvcFactory.newInstance(JobRequestFragmentViewMvc.class, container);
        mUser = Parcels.unwrap(getArguments().getParcelable(USER_KEY));

        mJobRequestFragmentController.bindUser(mUser);
        mJobRequestFragmentController.bindView(mViewMvc);
        return mViewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mJobRequestFragmentController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mJobRequestFragmentController.onStop();
    }
}

















