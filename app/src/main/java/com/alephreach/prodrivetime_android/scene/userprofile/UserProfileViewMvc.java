package com.alephreach.prodrivetime_android.scene.userprofile;

import com.alephreach.prodrivetime_android.application.common.ViewMvc;
import com.alephreach.prodrivetime_android.domain.data.User;

public interface UserProfileViewMvc extends ViewMvc {

    void showUserprofile(User user);

}
