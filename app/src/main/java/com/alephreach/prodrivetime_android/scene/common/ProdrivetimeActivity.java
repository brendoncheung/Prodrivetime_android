package com.alephreach.prodrivetime_android.scene.common;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;
import com.alephreach.prodrivetime_android.scene.common.baseclass.BaseActivity;
import com.alephreach.prodrivetime_android.scene.common.coordinator.ApplicationCoordinator;

import javax.inject.Inject;

public class ProdrivetimeActivity extends BaseActivity implements FragmentFrameWrapper {

    private FrameLayout mFrameLayout;
    @Inject ApplicationCoordinator mApplicationCoordinator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPresentationComponent().inject(this);

        configureView();
        configureApplicationCoordinator();
        configureToolbar();
    }

    private void configureView() {
        mFrameLayout = findViewById(R.id.main_activity_container_frame);
    }

    private void configureApplicationCoordinator() {
        mApplicationCoordinator.bindFragmentFrame(getFragmentFrameId());
    }

    private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getFragmentFrameId() {
        return mFrameLayout.getId();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mApplicationCoordinator.onStart();
    }


}
