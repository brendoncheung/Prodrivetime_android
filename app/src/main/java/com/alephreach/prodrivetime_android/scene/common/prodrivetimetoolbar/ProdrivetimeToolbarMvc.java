package com.alephreach.prodrivetime_android.scene.common.prodrivetimetoolbar;

import com.alephreach.prodrivetime_android.application.common.ObservableViewMvc;

public interface ProdrivetimeToolbarMvc extends ObservableViewMvc<ProdrivetimeToolbarMvc.Listener> {

    interface Listener {
        void searchBar(String text);
    }

    void hideToolbar();
    void showToolbar();

}
