package com.alephreach.prodrivetime_android.application.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseObservableViewMvc<ListenerType> extends BaseViewMvc implements ObservableViewMvc<ListenerType> {

    private Set<ListenerType> mListeners = new HashSet<>();

    @Override
    public void registerListener(ListenerType listenerType) {
        mListeners.add(listenerType);
    }

    @Override
    public void unregisterListener(ListenerType listenerType) {
        mListeners.remove(listenerType);
    }

    @Override
    public Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }
}
