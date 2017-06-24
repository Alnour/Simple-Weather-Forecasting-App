package com.example.root.weatherforcasting.factories;

import com.example.root.weatherforcasting.daily.DailyContractor;
import com.example.root.weatherforcasting.daily.DailyPresenter;
import com.example.root.weatherforcasting.settings.SettingsContractor;
import com.example.root.weatherforcasting.settings.SettingsPresenter;
import com.example.root.weatherforcasting.weekly.WeeklyContractor;
import com.example.root.weatherforcasting.weekly.WeeklyPresenter;

/**
 * Created by root on 23/06/17.
 */

public class PresentersFactory {
    public static DailyContractor.Presenter getDailyPresenter(DailyContractor.View view){
        return new DailyPresenter(view);
    }
    public static SettingsContractor.Presenter getSettingsPresenter(SettingsContractor.View view){
        return new SettingsPresenter(view);
    }

    public static WeeklyContractor.Presenter getWeeklyPresenter(WeeklyContractor.View view){
        return new WeeklyPresenter(view);
    }
}
