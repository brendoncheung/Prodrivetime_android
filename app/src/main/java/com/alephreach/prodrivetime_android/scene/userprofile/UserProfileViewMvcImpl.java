package com.alephreach.prodrivetime_android.scene.userprofile;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.application.common.BaseViewMvc;
import com.alephreach.prodrivetime_android.domain.User;
import com.facebook.stetho.common.StringUtil;

public class UserProfileViewMvcImpl extends BaseViewMvc implements UserProfileViewMvc {

    TextView driverName;
    TextView driverEmail;
    TextView driverId;
    TextView driverPhone;
    TextView driverState;
    TextView driverCity;
    TextView driverExperience;

    TextView numberOfRequests;


    public UserProfileViewMvcImpl(LayoutInflater inflater, ViewGroup viewGroup) {
        setRootView(inflater.inflate(R.layout.fragment_user_profile, viewGroup, false));
        configureView();
    }

    private void configureView() {

        driverName = findViewById(R.id.user_profile_driver_name);
        driverEmail = findViewById(R.id.user_profile_driver_email);
        driverId = findViewById(R.id.user_profile_driver_id);
        driverPhone = findViewById(R.id.user_profile_driver_phone);
        driverState = findViewById(R.id.user_profile_driver_state);
        driverCity = findViewById(R.id.user_profile_driver_city);
        driverExperience = findViewById(R.id.user_profile_driver_experience);
        numberOfRequests = findViewById(R.id.user_profile_number_of_requests);
    }

    @Override
    public void showUserprofile(User user) {
        driverName.setText(user.getName());
        driverEmail.setText(user.getEmail());
        driverId.setText(user.getDriverId());
        driverPhone.setText(user.getPhoneNumber());
        driverState.setText(user.getState());
        driverCity.setText(user.getCity());
        driverExperience.setText(user.getExperience());
    }

    @Override
    public void showNumberOfAvailableJob(int number) {
        String request;
        if(number > 1) {
            request = String.format("%d requests", number);
        } else {
            request = String.format("%d request", number);
        }
        numberOfRequests.setText(request);
    }
}
