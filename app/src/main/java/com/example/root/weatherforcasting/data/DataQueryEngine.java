package com.example.root.weatherforcasting.data;

import java.util.List;
import java.util.Objects;

/**
 * Created by root on 23/06/17.
 */

public class DataQueryEngine<T> {
    public DataQueryEngine(){

    }
    public  void getData(final List<DataStore> dataStores,
                         final List<Object> keys,
                         final StoreCallBack<T> onSuccess) throws Exception {
        if(keys.size() != dataStores.size())
            throw new Exception("Keys length is not equal to dataStores length");
        for (int i = 0; i < dataStores.size(); i++){
            final Object key = keys.get(i);
            DataStore dataStore = dataStores.get(i);
            if(dataStore.isItemValid(key)) {
                final int finalI = i;
                StoreCallBack<T> addedReverseSaving = new StoreCallBack<T>() {
                    @Override
                    public void performTask(T data) {
                        onSuccess.performTask(data);
                        for(int j = finalI; j >= 0; j--)
                            dataStores.get(j).saveData(data, keys.get(j));
                    }
                };

                dataStore.getData(key, addedReverseSaving);
                break;
            }
        }
    }
}
