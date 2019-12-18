package com.alephreach.prodrivetime_android.domain;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JobRequest {

    @SerializedName("id") private String id;
    @SerializedName("request_id") private String requestId;
    @SerializedName("business_name") private String companyName;
    @SerializedName("business_email") private String companyEmail;
    @SerializedName("title") private String loadTitle;
    @SerializedName("details") private String details;
    @SerializedName("load_description") private String loadDescription;
    @SerializedName("amount_offered") private String amountOffered;
    @SerializedName("pickup_address") private String pickUpAddress;
    @SerializedName("dropoff_address") private String dropOffAddress;
    @SerializedName("timestamp") private String timeStamp;
    @SerializedName("mandatory_delivery_date") private String deliveryDate;

    public String getCompanyName() {
        return companyName;
    }

    public String getLoadTitle() {
        return loadTitle;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public String getDropOffAddress() {
        return dropOffAddress;
    }

    public String getLoadDescription() {
        return loadDescription;
    }

    public String getAmountOffered() {
        return amountOffered;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getRequestId() { return requestId; }

    public String getDetails() {
        return details;
    }

    public String getTimeAgo() {

        String format = "yyyy-MM-dd HH:mm:ss";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        Date now = new Date();

        Date past = new Date();

        try {
            past = simpleDateFormat.parse(getTimeStamp());
        } catch (Exception e) {

        }

        long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
        long minutes=TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
        long hours=TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
        long days=TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());

        if(seconds < 60)
        {
            return "Just now";
        }
        else if(minutes < 60)
        {
            return minutes + " minutes ago";
        }
        else if(hours < 24)
        {
            return hours + " hours ago";
        }
        else
        {
            return days + " days ago";
        }


    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


}
