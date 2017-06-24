package com.example.root.weatherforcasting.data;

import android.content.Context;

/**
 * Created by root on 23/06/17.
 */

public class SharedPrefDataStore<T> extends DataStore<T,String> {
    private  Context context;
    private Class itemClass;
    private long maxAge;

    public SharedPrefDataStore(Context context, Class itemClass, int maxAge){
        this.context = context;
        this.itemClass = itemClass;
        this.maxAge = maxAge;
    }
    @Override
    public void getData(String key,StoreCallBack<T> onSuccess) {
        onSuccess.performTask((T) Preferences.getInstance(context).getSavedItem(key, itemClass));
    }

    @Override
    public void saveData(T data, String key) {
        Preferences.getInstance(context).saveItem(data, itemClass,key);
    }

    @Override
    public boolean isItemValid(String key) {
        long lastReadTime = Preferences.getInstance(context).lastReadTime(key);
        long time2Compare = System.currentTimeMillis();
        return time2Compare < (lastReadTime + maxAge);
    }
}
