package com.alephreach.prodrivetime_android.application.di.components;

import com.alephreach.prodrivetime_android.application.di.modules.PresentationModule;
import com.alephreach.prodrivetime_android.scene.common.ProdrivetimeActivity;
import com.alephreach.prodrivetime_android.scene.login.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PresentationModule.class})
public interface PresentationComponent {
    void inject(ProdrivetimeActivity activity);
    void inject(LoginFragment loginFragment);
}
