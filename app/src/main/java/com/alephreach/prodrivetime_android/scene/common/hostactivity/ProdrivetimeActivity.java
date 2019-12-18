package com.alephreach.prodrivetime_android.scene.common.hostactivity;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.application.di.factory.ViewMvcFactory;
import com.alephreach.prodrivetime_android.scene.common.baseclass.BaseActivity;
import com.alephreach.prodrivetime_android.scene.common.coordinator.ApplicationCoordinator;
import com.alephreach.prodrivetime_android.scene.common.wrapper.FragmentFrameWrapper;

import javax.inject.Inject;

public class ProdrivetimeActivity extends BaseActivity implements FragmentFrameWrapper {

    private FrameLayout mFrameLayout;
    private ProdrivetimeActivityViewMvc mProdrivetimeActivityViewMvc;

    @Inject ProdrivetimeActivityController mProdrivetimeActivityController;
    @Inject ApplicationCoordinator mApplicationCoordinator;
    @Inject ViewMvcFactory mViewMvcFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getPresentationComponent().inject(this);

        mProdrivetimeActivityViewMvc = mViewMvcFactory.newInstance(
                ProdrivetimeActivityViewMvc.class,
                null);

        setContentView(mProdrivetimeActivityViewMvc.getRootView());

        configureView();
        configureController();
        configureApplicationCoordinator();
        configureToolbar();
    }

    private void configureController() {
        mProdrivetimeActivityController.bindView(mProdrivetimeActivityViewMvc);
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
        //toolbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getFragmentFrameId() {
        return mFrameLayout.getId();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mProdrivetimeActivityController.onStart();
        mApplicationCoordinator.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mProdrivetimeActivityController.onStop();
    }
}
