package com.example.trietlam.test_rxjava_retrofit;

import android.util.Log;

import com.example.trietlam.test_rxjava_retrofit.remote.APIService;
import com.example.trietlam.test_rxjava_retrofit.remote.APIUtils;

import org.junit.Test;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    int size = 0;


    @Test
    public void returnAValue(){
        APIService mAPIService = APIUtils.getAPIService();
        mAPIService.getListAnroid().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Android>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Android> value) {
                        assertTrue(value.size()==3);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }


}