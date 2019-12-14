package com.alephreach.prodrivetime_android.domain.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobRequestHistory {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("request_id")
    @Expose
    public String requestId;
    @SerializedName("final_id")
    @Expose
    public String finalId;
    @SerializedName("business_name")
    @Expose
    public String businessName;
    @SerializedName("business_email")
    @Expose
    public String businessEmail;
    @SerializedName("driver_email")
    @Expose
    public String driverEmail;
    @SerializedName("driver_name")
    @Expose
    public String driverName;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("details")
    @Expose
    public String details;
    @SerializedName("load_description")
    @Expose
    public String loadDescription;
    @SerializedName("amount_offered")
    @Expose
    public String amountOffered;
    @SerializedName("pickup_address")
    @Expose
    public String pickupAddress;
    @SerializedName("dropoff_address")
    @Expose
    public String dropoffAddress;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getFinalId() {
        return finalId;
    }

    public void setFinalId(String finalId) {
        this.finalId = finalId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getDriverEmail() {
        return driverEmail;
    }

    public void setDriverEmail(String driverEmail) {
        this.driverEmail = driverEmail;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLoadDescription() {
        return loadDescription;
    }

    public void setLoadDescription(String loadDescription) { this.loadDescription = loadDescription; }

    public String getAmountOffered() {
        return amountOffered;
    }

    public void setAmountOffered(String amountOffered) {
        this.amountOffered = amountOffered;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDropoffAddress() {
        return dropoffAddress;
    }

    public void setDropoffAddress(String dropoffAddress) {
        this.dropoffAddress = dropoffAddress;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
