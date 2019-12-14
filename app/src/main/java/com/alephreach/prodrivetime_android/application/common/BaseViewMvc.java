package com.alephreach.prodrivetime_android.application.common;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class BaseViewMvc implements ViewMvc {

    private View mRootView;
    private Bundle mViewState;

    @Override
    public View getRootView() {
        return mRootView;
    }

    protected Context getContext() {
        return mRootView.getContext();
    }

    protected void setRootView(View rootView) {
        mRootView = rootView;
    }

    protected void setViewState(Bundle bundle) {
        mViewState = bundle;
    }

    protected <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }
}
