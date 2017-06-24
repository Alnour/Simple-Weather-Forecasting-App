package com.example.root.weatherforcasting.daily;

import com.example.root.weatherforcasting.models.api_models.CityResponse;
import com.example.root.weatherforcasting.base.BasePresenter;
import com.example.root.weatherforcasting.base.ContextView;

/**
 * Created by Alnour Ahmed Khalifa on 23/06/17.
 */

public interface DailyContractor {
    interface Presenter extends BasePresenter {
        void getData();
    }
    interface View extends ContextView<Presenter> {
        void showData(CityResponse response);
        void openSettings();
        void openWeeklyForecast();
    }

}
