package com.alephreach.prodrivetime_android.application.di.modules;

import com.alephreach.prodrivetime_android.networking.Constants;
import com.alephreach.prodrivetime_android.networking.ProdrivetimeApi;
import com.alephreach.prodrivetime_android.networking.pushnotification.FetchFireBaseTokenUseCase;
import com.alephreach.prodrivetime_android.networking.usecase.FetchJobRequestUseCase;
import com.alephreach.prodrivetime_android.networking.usecase.FetchUserProfileAndLoginUseCase;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    @Singleton
    @Provides
    Retrofit getRetrofit(OkHttpClient client) {

        return new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    @Singleton
    @Provides
    ProdrivetimeApi getProdrivetimeApi(Retrofit retrofit) {
        return retrofit.create(ProdrivetimeApi.class);
    }

    @Provides
    HttpLoggingInterceptor getInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    OkHttpClient getHttpClient(HttpLoggingInterceptor interceptor,StethoInterceptor stethoInterceptor){
        return new OkHttpClient.Builder().
                addInterceptor(interceptor).
                addNetworkInterceptor(stethoInterceptor)
                .build();
    }

    @Provides
    StethoInterceptor getStethoIntercepter() {
        return new StethoInterceptor();
    }

    @Provides
    FetchUserProfileAndLoginUseCase getFetchUserProfileAndLoginUseCase(ProdrivetimeApi api) {
        return new FetchUserProfileAndLoginUseCase(api);
    }

    @Provides
    FetchFireBaseTokenUseCase getFetchFireBaseTokenUseCase() {
        return new FetchFireBaseTokenUseCase();
    }

    @Provides
    FetchJobRequestUseCase getFetchJobRequestUseCase(ProdrivetimeApi api) {
        return new FetchJobRequestUseCase(api);
    }

}
