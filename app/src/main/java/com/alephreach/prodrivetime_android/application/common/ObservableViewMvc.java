package com.alephreach.prodrivetime_android.application.common;

import java.util.Set;

public interface ObservableViewMvc<ListenerType> extends ViewMvc {

    void registerListener(ListenerType listenerType);
    void unregisterListener(ListenerType listenerType);
    Set<ListenerType> getListeners();

}
