package com.example.root.weatherforcasting.base;

import android.content.Context;

import com.example.root.weatherforcasting.base.BaseView;

/**
 * Created by root on 23/06/17.
 */

public interface ContextView<T> extends BaseView<T> {
    Context getContext();
    void showMessage(String message);
}
