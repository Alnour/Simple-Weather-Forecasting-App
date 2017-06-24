package com.example.root.weatherforcasting.daily;


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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 23/06/17.
 */

public class DailyPresenter implements DailyContractor.Presenter {
    public static final int MAX_AGE = 1000*60*5;
    private DailyContractor.View view;
    private SharedPrefDataStore<CityResponse> sharedPrefDataStore;
    private NetworkDataStore<CityResponse> networkDataStore;
    private DataQueryEngine<CityResponse> dataQueryEngine= new DataQueryEngine<>();
    private List<DataStore> dataStoreList = new ArrayList<>(2);
    private List<Object> keys = new ArrayList<>();
    private City chosenCity;



    public DailyPresenter(final DailyContractor.View view){
        this.view = view;
        chosenCity = Preferences.getChosenCity(view.getContext());
        sharedPrefDataStore = new SharedPrefDataStore<>(view.getContext(),
                CityResponse.class,
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
        keys.add(RetrofitCaller.getMainAPIs().getDailyForecast(chosenCity.getId()+""));
    }
    @Override
    public void getData() {

        try {
            dataQueryEngine.getData(dataStoreList, keys, new StoreCallBack<CityResponse>() {
                @Override
                public void performTask(CityResponse data) {
                    view.showData(data);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
