package com.example.trietlam.test_rxjava_retrofit.remote;

import com.example.trietlam.test_rxjava_retrofit.Android;

import java.util.List;
import java.util.Observer;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("test")
    Observable<List<Android>> getListAnroid();

}
