package com.example.root.weatherforcasting.data;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 23/06/17.
 */

public class NetworkDataStore<T> extends DataStore<T, Call<T>> {

    private Task onFailure;

    public NetworkDataStore(Task onFailure){
        this.onFailure = onFailure;
    }

    @Override
    public void getData(Call<T> key, final StoreCallBack<T> onSuccess){
        key.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response.isSuccessful())
                    onSuccess.performTask(response.body());
                else
                    onFailure.performTask();
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                onFailure.performTask();
                Log.i("fail", t.getMessage() + ", " + t.getStackTrace() + ", " + t.toString());
            }
        });
    }

    @Override
    public void saveData(T data, Call<T> key) {

    }

    @Override
    public boolean isItemValid(Call<T> key) {
        return true;
    }
}
