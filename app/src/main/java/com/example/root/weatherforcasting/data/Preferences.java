package com.example.root.weatherforcasting.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.root.weatherforcasting.base.ContextView;
import com.example.root.weatherforcasting.models.api_models.City;
import com.google.gson.Gson;

/**
 * Created by root on 23/06/17.
 */

public class Preferences {
    public static final String APP_KEY = "APP_KEY";
    public static final String LAST_READ_TIME = "time_to_live";
    public static final String CHOSEN_CITY = "CHOSEN_CITY";
    private static Preferences preferences;
    private SharedPreferences sharedPreferences;
    public Preferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(APP_KEY,Context.MODE_PRIVATE);
    }

    public static Preferences getInstance(Context context){
        if(preferences == null)
            preferences = new Preferences(context);
        return preferences;
    }

    public static City getChosenCity(Context context) {
        City chosenCity =  getInstance(context).getSavedItem(CHOSEN_CITY, City.class);
        if(chosenCity == null)
            chosenCity = new City(204283, "Watsa");
        return chosenCity;
    }

    public <T> void saveItem(T item, Class itemClass, String key){

        Gson gson = new Gson();
        String serialized = gson.toJson(item, itemClass);
        preferences.sharedPreferences.edit().putString(key, serialized).apply();
        preferences.sharedPreferences.edit().putLong(key+ LAST_READ_TIME,
                System.currentTimeMillis()).apply();
    }

    public <T> T getSavedItem(String key, Class itemClass){
        Gson gson = new Gson();
        String serialized = preferences.sharedPreferences.getString(key, "");
        if(TextUtils.isEmpty(serialized))
            return null;
        return (T) gson.fromJson(serialized, itemClass);
    }

    public  long lastReadTime(String key){
        return preferences.sharedPreferences.getInt(key + LAST_READ_TIME, 0);
    }
}
