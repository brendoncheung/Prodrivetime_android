package com.alephreach.prodrivetime_android.scene.common.hostactivity;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.application.common.BaseObservableViewMvc;
import com.google.android.material.navigation.NavigationView;

public class ProdrivetimeActivityViewMvcImpl extends BaseObservableViewMvc<ProdrivetimeActivityViewMvc.Listener>
        implements ProdrivetimeActivityViewMvc {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private TextView mName;
    private TextView mDriverId;

    public ProdrivetimeActivityViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.navigation_drawer, container, false));
        configureView();
        configureViewListener();
    }

    private void configureView() {
        mNavigationView = findViewById(R.id.navigation_drawer_view);
        mDrawerLayout = findViewById(R.id.navigation_drawer_layout);
        mName = mNavigationView.getHeaderView(0).findViewById(R.id.navigation_header_name);
        mDriverId = mNavigationView.getHeaderView(0).findViewById(R.id.navigation_header_id);
    }

    private void configureViewListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                for(Listener listener : getListeners()) {
                    listener.onNavigationItemClicked(menuItem.getItemId());
                }
                return true;
            }
        });
    }


    @Override
    public void closeNavigationDrawer() {
        mDrawerLayout.closeDrawers();
    }

    @Override
    public void bindNavigationHeader(String name, String id) {
        mName.setText(name);
        mDriverId.setText(id);
    }
}
