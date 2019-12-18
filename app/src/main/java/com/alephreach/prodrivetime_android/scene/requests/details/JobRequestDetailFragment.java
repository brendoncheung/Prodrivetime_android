package com.alephreach.prodrivetime_android.scene.requests.details;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alephreach.prodrivetime_android.domain.JobRequest;
import com.alephreach.prodrivetime_android.scene.common.baseclass.BaseFragment;

import org.parceler.Parcels;

public class JobRequestDetailFragment extends BaseFragment {

    public static final String REQUEST_DETAIL_KEY = "REQUEST_DETAIL_KEY";
    private JobRequest mJobRequest;

    public static JobRequestDetailFragment newInstance(JobRequest request) {

        JobRequestDetailFragment fragment = new JobRequestDetailFragment();

        Bundle bundle = new Bundle();
        Parcelable requestParcel = Parcels.wrap(request);
        bundle.putParcelable(REQUEST_DETAIL_KEY, requestParcel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mJobRequest = Parcels.unwrap(getArguments().getParcelable(REQUEST_DETAIL_KEY));


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
