package com.example.root.weatherforcasting.settings;

import com.example.root.weatherforcasting.data.Preferences;
import com.example.root.weatherforcasting.data.db.CountriesDataBase;
import com.example.root.weatherforcasting.models.api_models.City;
import com.example.root.weatherforcasting.models.api_models.Country;

/**
 * Created by root on 24/06/17.
 */

public class SettingsPresenter implements SettingsContractor.Presenter {
    private final SettingsContractor.View view;

    public SettingsPresenter(SettingsContractor.View view) {
        this.view  = view;
    }

    @Override
    public void getCountries() {
        CountriesDataBase countriesDataBase = new CountriesDataBase(view.getContext());
        view.showCountries(countriesDataBase.getCountries());
    }

    @Override
    public void getCountriesCities(Country country) {
        CountriesDataBase countriesDataBase = new CountriesDataBase(view.getContext());
        view.showCities(countriesDataBase.getCities(country.getId()));
    }

    @Override
    public void saveChosenCity(City chosenCity) {
        Preferences.getInstance(view.getContext()).clearCach();
        Preferences.getInstance(view.getContext()).saveItem(chosenCity, City.class, Preferences.CHOSEN_CITY);
        view.goToMainPage();
    }
}
