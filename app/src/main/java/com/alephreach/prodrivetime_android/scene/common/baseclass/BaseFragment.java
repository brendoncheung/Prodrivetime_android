package com.alephreach.prodrivetime_android.scene.common.baseclass;

import androidx.fragment.app.Fragment;

import com.alephreach.prodrivetime_android.application.di.components.PresentationComponent;
import com.alephreach.prodrivetime_android.scene.common.hostactivity.ProdrivetimeActivity;

public class BaseFragment extends Fragment {

    public PresentationComponent getPresentationComponent() {

        return ((ProdrivetimeActivity)requireActivity()).getPresentationComponent();
    }
}
