package com.example.root.weatherforcasting.weekly;

import com.example.root.weatherforcasting.base.BasePresenter;
import com.example.root.weatherforcasting.base.ContextView;
import com.example.root.weatherforcasting.models.api_models.WeeklyResponse;

/**
 * Created by Alnour Ahmed Khalifa on 23/06/17.
 */

public interface WeeklyContractor {
    interface View extends ContextView<Presenter>{
        void showData(WeeklyResponse weeklyResponse);
        void goToDaily();

        void openSettings();
    }
    interface Presenter extends BasePresenter {
        void getData();
    }
}
