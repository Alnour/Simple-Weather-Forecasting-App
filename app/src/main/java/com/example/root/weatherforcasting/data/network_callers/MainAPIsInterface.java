package com.example.root.weatherforcasting.data.network_callers;

import com.example.root.weatherforcasting.models.api_models.CityResponse;
import com.example.root.weatherforcasting.models.api_models.WeeklyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by root on 23/06/17.
 */

public interface MainAPIsInterface {
    @GET("/data/2.5/weather?APPID=" + APIConstants.APP_ID)
    Call<CityResponse> getDailyForecast(@Query("id") String cityId);

    @GET("/data/2.5/forecast/daily?APPID=" + APIConstants.APP_ID + "&cnt=7")
    Call<WeeklyResponse> getWeeklyResponse(@Query("id") String cityId);
}
