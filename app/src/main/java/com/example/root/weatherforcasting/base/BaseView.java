package com.example.root.weatherforcasting.base;

/**
 * Created by root on 23/06/17.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
    void showMessage(String message);
}
