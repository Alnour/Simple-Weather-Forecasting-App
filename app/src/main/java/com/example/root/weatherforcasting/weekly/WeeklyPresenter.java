package com.example.root.weatherforcasting.weekly;

import com.example.root.weatherforcasting.daily.DailyContractor;
import com.example.root.weatherforcasting.data.DataQueryEngine;
import com.example.root.weatherforcasting.data.DataStore;
import com.example.root.weatherforcasting.data.NetworkDataStore;
import com.example.root.weatherforcasting.data.Preferences;
import com.example.root.weatherforcasting.data.SharedPrefDataStore;
import com.example.root.weatherforcasting.data.StoreCallBack;
import com.example.root.weatherforcasting.data.Task;
import com.example.root.weatherforcasting.data.network_callers.RetrofitCaller;
import com.example.root.weatherforcasting.models.api_models.City;
import com.example.root.weatherforcasting.models.api_models.CityResponse;
import com.example.root.weatherforcasting.models.api_models.WeeklyResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 24/06/17.
 */

public class WeeklyPresenter implements WeeklyContractor.Presenter {
    public static final int MAX_AGE = 1000*60*5;
    private WeeklyContractor.View view;
    private SharedPrefDataStore<WeeklyResponse> sharedPrefDataStore;
    private NetworkDataStore<WeeklyResponse> networkDataStore;
    private DataQueryEngine<WeeklyResponse> dataQueryEngine= new DataQueryEngine<>();
    private List<DataStore> dataStoreList = new ArrayList<>(2);
    private List<Object> keys = new ArrayList<>();
    private City chosenCity;

    public WeeklyPresenter(final WeeklyContractor.View view){
        this.view = view;
        chosenCity = Preferences.getChosenCity(view.getContext());
        sharedPrefDataStore = new SharedPrefDataStore<>(view.getContext(),
                WeeklyResponse.class,
                MAX_AGE);
        networkDataStore = new NetworkDataStore<>(new Task() {
            @Override
            public void performTask() {
                view.showMessage("Failed to get data");
            }
        });
        dataStoreList.add(sharedPrefDataStore);
        dataStoreList.add(networkDataStore);
        keys.add("CITY");
        keys.add(RetrofitCaller.getMainAPIs().getWeeklyResponse(chosenCity.getId()+""));

    }
    @Override
    public void getData() {


        try {
            dataQueryEngine.getData(dataStoreList, keys, new StoreCallBack<WeeklyResponse>() {
                @Override
                public void performTask(WeeklyResponse data) {
                    view.showData(data);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
