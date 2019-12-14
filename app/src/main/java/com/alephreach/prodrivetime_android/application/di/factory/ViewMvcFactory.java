package com.alephreach.prodrivetime_android.application.di.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alephreach.prodrivetime_android.application.common.ViewMvc;
import com.alephreach.prodrivetime_android.scene.login.LoginFragmentViewMvc;
import com.alephreach.prodrivetime_android.scene.login.LoginFragmentViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public <T extends ViewMvc> T newInstance(Class<T> viewMvcClass, ViewGroup container) {

        ViewMvc viewMvc;

        if(viewMvcClass == LoginFragmentViewMvc.class) {
            viewMvc = new LoginFragmentViewMvcImpl(mLayoutInflater, container);
        } else {
            throw new IllegalArgumentException("ViewMvc class not supported");
        }

        return (T) viewMvc;

    }
}
