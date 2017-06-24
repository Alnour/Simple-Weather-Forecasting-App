package com.example.root.weatherforcasting.data;

import java.util.List;
import java.util.Objects;

/**
 * Created by root on 23/06/17.
 */

public class DataQueryEngine<T> {
    public DataQueryEngine(){

    }
    public  void getData(List<DataStore> dataStores,
                        List<Object> keys,
                        StoreCallBack<T> onSuccess) throws Exception {
        if(keys.size() != dataStores.size())
            throw new Exception("Keys length is not equal to dataStores length");
        for (int i = 0; i < dataStores.size(); i++){
            Object key = keys.get(i);
            DataStore dataStore = dataStores.get(i);
            if(dataStore.isItemValid(key)) {
                dataStore.getData(key, onSuccess);
                break;
            }
        }
    }
}
