package com.example.root.weatherforcasting.data;

/**
 * Created by root on 23/06/17.
 */

public abstract class DataStore<T, Key> {

    public abstract void getData(Key key, StoreCallBack<T> onSuccess);

    public abstract void saveData(T data, Key key);
    public abstract boolean isItemValid(Key key);
}
