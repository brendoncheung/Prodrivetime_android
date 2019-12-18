package com.alephreach.prodrivetime_android.application.di.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alephreach.prodrivetime_android.application.common.ViewMvc;
import com.alephreach.prodrivetime_android.scene.common.hostactivity.ProdrivetimeActivityViewMvc;
import com.alephreach.prodrivetime_android.scene.common.hostactivity.ProdrivetimeActivityViewMvcImpl;
import com.alephreach.prodrivetime_android.scene.login.LoginFragmentViewMvc;
import com.alephreach.prodrivetime_android.scene.login.LoginFragmentViewMvcImpl;
import com.alephreach.prodrivetime_android.scene.requests.JobRequestFragmentViewMvc;
import com.alephreach.prodrivetime_android.scene.requests.JobRequestFragmentViewMvcImpl;
import com.alephreach.prodrivetime_android.scene.userprofile.UserProfileViewMvc;
import com.alephreach.prodrivetime_android.scene.userprofile.UserProfileViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public <T extends ViewMvc> T newInstance(Class<T> viewMvcClass, ViewGroup container) {

        ViewMvc viewMvc;

        if(viewMvcClass == LoginFragmentViewMvc.class) {
            viewMvc = new LoginFragmentViewMvcImpl(mLayoutInflater, container);
        }

        else if (viewMvcClass == UserProfileViewMvc.class) {
            viewMvc = new UserProfileViewMvcImpl(mLayoutInflater, container);
        }

        else if (viewMvcClass == ProdrivetimeActivityViewMvc.class) {
            viewMvc = new ProdrivetimeActivityViewMvcImpl(mLayoutInflater, container);
        }

        else if (viewMvcClass == JobRequestFragmentViewMvc.class) {
            viewMvc = new JobRequestFragmentViewMvcImpl(mLayoutInflater, container);
        }

        else {
            throw new IllegalArgumentException("ViewMvc class not supported");
        }

        return (T) viewMvc;

    }
}
