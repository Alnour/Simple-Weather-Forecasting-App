package com.example.root.weatherforcasting.data.network_callers;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.root.weatherforcasting.data.network_callers.APIConstants.BASE_URL;

/**
 * Created by root on 23/06/17.
 */

public class RetrofitCaller {
    private static MainAPIsInterface service;

    public static MainAPIsInterface getMainAPIs() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if(service != null)
            return service;
        Retrofit mainAPIs = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        service = mainAPIs.create(MainAPIsInterface.class);
        return service;
    }
}
