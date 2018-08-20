package com.example.trietlam.test_rxjava_retrofit.remote;

public class APIUtils {

    private static final String BASE_URL = "http://192.168.20.126:3000/";

    public static APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}

