package com.alephreach.prodrivetime_android.scene.common.hostactivity;

import com.alephreach.prodrivetime_android.application.common.ObservableViewMvc;

public interface ProdrivetimeActivityViewMvc extends ObservableViewMvc<ProdrivetimeActivityViewMvc.Listener> {

    interface Listener {
        void onNavigationItemClicked(int id);
    }

    void closeNavigationDrawer();
    void bindNavigationHeader(String name, String id);
}
