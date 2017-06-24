package com.example.root.weatherforcasting.settings;

import com.example.root.weatherforcasting.base.BasePresenter;
import com.example.root.weatherforcasting.base.ContextView;
import com.example.root.weatherforcasting.models.api_models.City;
import com.example.root.weatherforcasting.models.api_models.Country;

import java.util.List;

/**
 * Created by Alnour Ahmed Khalifa on 23/06/17.
 */

public interface SettingsContractor {
    interface Presenter extends BasePresenter{
        void getCountries();
        void getCountriesCities(Country country);
        void saveChosenCity(City chosenCity);
    }
    interface View extends ContextView<Presenter>{
        void showCountries(List<Country> countries);
        void showCities(List<City> cities);
        void goToMainPage();
    }
}
