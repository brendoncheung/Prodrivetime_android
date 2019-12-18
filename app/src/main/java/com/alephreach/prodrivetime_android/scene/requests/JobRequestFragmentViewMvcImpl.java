package com.alephreach.prodrivetime_android.scene.requests;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.application.common.BaseObservableViewMvc;
import com.alephreach.prodrivetime_android.domain.JobRequest;

import java.util.List;

public class JobRequestFragmentViewMvcImpl extends BaseObservableViewMvc<JobRequestFragmentViewMvc.Listener> implements JobRequestFragmentViewMvc {

    private RecyclerView mRecyclerView;
    private JobRequestListAdapter mJobRequestListAdapter;

    public JobRequestFragmentViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.fragment_request, container, false));
        configureView();
        configureAdapter();
    }

    private void configureView() {
        mRecyclerView = findViewById(R.id.request_recycler_view);
    }

    private void configureAdapter() {
        mJobRequestListAdapter = new JobRequestListAdapter();
        mJobRequestListAdapter.bindListener(new JobRequestListAdapter.Listener() {
            @Override
            public void onRequestClicked(JobRequest request) {
                for(Listener listener : getListeners()) {
                    listener.onRequestClicked(request);
                }
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mJobRequestListAdapter);

    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }

    @Override
    public void showEmptyState() {

    }

    @Override
    public void hideEmptyState() {

    }

    @Override
    public void hideSwipeIndicator() {

    }

    @Override
    public void bindRequest(List<JobRequest> jobRequestList) {
        mJobRequestListAdapter.bindRequests(jobRequestList);
    }
}
