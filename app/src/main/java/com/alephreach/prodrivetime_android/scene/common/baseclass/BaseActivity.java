package com.alephreach.prodrivetime_android.scene.common.baseclass;

import androidx.appcompat.app.AppCompatActivity;

import com.alephreach.prodrivetime_android.application.ProdrivetimeApplication;
import com.alephreach.prodrivetime_android.application.di.components.ApplicationComponent;
import com.alephreach.prodrivetime_android.application.di.components.DaggerPresentationComponent;
import com.alephreach.prodrivetime_android.application.di.components.PresentationComponent;
import com.alephreach.prodrivetime_android.application.di.modules.PresentationModule;
import com.alephreach.prodrivetime_android.scene.common.wrapper.FragmentFrameWrapper;

public class BaseActivity extends AppCompatActivity {

    private PresentationComponent mPresentationComponent;

    public ApplicationComponent getApplicationComponent() {
        return ((ProdrivetimeApplication) getApplication()).getApplicationComponent();
    }

    public PresentationComponent getPresentationComponent() {

        if(mPresentationComponent == null) {
            mPresentationComponent = DaggerPresentationComponent.builder()
                    .presentationModule(new PresentationModule(getApplicationComponent(),
                            this))
                    .build();
        }
        return mPresentationComponent;
    }
}
