package com.alephreach.prodrivetime_android.domain;

import com.google.gson.annotations.SerializedName;

public class CompanyProfile {

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getnPhoneNumber() {
        return nPhoneNumber;
    }

    public void setnPhoneNumber(String nPhoneNumber) {
        this.nPhoneNumber = nPhoneNumber;
    }

    @SerializedName("name")
    private String mName;

    @SerializedName("email_addr")
    private String mEmail;

    @SerializedName("number")
    private String nPhoneNumber;
}
