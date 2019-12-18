package com.alephreach.prodrivetime_android.application.di.components;

import com.alephreach.prodrivetime_android.application.di.modules.PresentationModule;
import com.alephreach.prodrivetime_android.scene.common.hostactivity.ProdrivetimeActivity;
import com.alephreach.prodrivetime_android.scene.login.LoginFragment;
import com.alephreach.prodrivetime_android.scene.requests.JobRequestFragment;
import com.alephreach.prodrivetime_android.scene.userprofile.UserProfileFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PresentationModule.class})
public interface PresentationComponent {
    void inject(ProdrivetimeActivity activity);
    void inject(LoginFragment loginFragment);
    void inject(UserProfileFragment userProfileFragment);
    void inject(JobRequestFragment jobRequestFragment);
}
