package com.alephreach.prodrivetime_android.application;

import android.app.Application;

import com.alephreach.prodrivetime_android.application.di.components.ApplicationComponent;
import com.alephreach.prodrivetime_android.application.di.components.DaggerApplicationComponent;

public class ProdrivetimeApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.create();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }


}
