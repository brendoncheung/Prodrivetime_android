package com.alephreach.prodrivetime_android.domain;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class User {

    @SerializedName("driver_id")
    public String driverId;
    public String name;
    public String email;
    @SerializedName("phone")
    public String phoneNumber;
    public String city;
    public String state;
    public String experience;

    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getExperience() {
        return experience;
    }

    @ParcelConstructor
    public User(String driverId,
                      String name,
                      String email,
                      String phoneNumber,
                      String city,
                      String state,
                      String experience) {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.experience = experience;
    }

}

