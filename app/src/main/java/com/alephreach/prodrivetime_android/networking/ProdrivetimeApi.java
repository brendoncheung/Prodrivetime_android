package com.alephreach.prodrivetime_android.networking;

import com.alephreach.prodrivetime_android.domain.CompanyProfile;
import com.alephreach.prodrivetime_android.domain.JobRequest;
import com.alephreach.prodrivetime_android.domain.JobRequestHistory;
import com.alephreach.prodrivetime_android.domain.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProdrivetimeApi {

    @FormUrlEncoded
    @POST("api/mobileApi/mobileDriverLogin")
    Call<User> fetchUserProfile(@Field("email") String email,
                                @Field("password") String password,
                                @Field("firebaseToken") String firebaseToken);
    @FormUrlEncoded
    @POST("api/driverApi/driverRequestLoad")
    Call<List<JobRequest>> fetchJobRequests(
            @Field("driverEmail") String driverEmail);

    @FormUrlEncoded
    @POST("api/mobileApi/mobileDriverAcceptLoad")
    Call<ResponseBody> acceptRequestLoad(@Field("requestId") String requestId,
                                         @Field("driverEmail") String driverEmail,
                                         @Field("driverId") String driverId);

    @POST("controls/logout.php")
    Call<ResponseBody> userLogOff();

    @FormUrlEncoded
    @POST("api/mobileApi/clientInfo.php")
    Call<CompanyProfile> fetchCompanyProfile(@Field("clientEmail") String clientEmail);

    @FormUrlEncoded
    @POST("api/mobileApi/driverMobileHistory.php")
    Call<List<JobRequestHistory>> fetchJobRequestsHistory(
            @Field("driverEmail") String driverEmail);

}
