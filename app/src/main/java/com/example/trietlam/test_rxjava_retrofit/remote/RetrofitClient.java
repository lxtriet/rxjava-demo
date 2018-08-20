package com.example.trietlam.test_rxjava_retrofit.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String BASE_URL){

        OkHttpClient builder = new OkHttpClient.Builder()
                                            .readTimeout(5000, TimeUnit.MILLISECONDS)
                                            .writeTimeout(5000, TimeUnit.MILLISECONDS)
                                            .connectTimeout(10000, TimeUnit.MILLISECONDS)
                                            .retryOnConnectionFailure(true)
                                            .build();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;

    }


}
