package com.example.root.weatherforcasting.settings;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.root.weatherforcasting.R;
import com.example.root.weatherforcasting.daily.DailyAcitivity;
import com.example.root.weatherforcasting.databinding.ActivitySettingsBinding;
import com.example.root.weatherforcasting.factories.PresentersFactory;
import com.example.root.weatherforcasting.models.api_models.City;
import com.example.root.weatherforcasting.models.api_models.Country;

import java.util.List;

public class SettingsActivity extends AppCompatActivity implements SettingsContractor.View{

    private SettingsContractor.Presenter presenter;
    ActivitySettingsBinding activitySettingsBinding;
    private boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(PresentersFactory.getSettingsPresenter(this));
        activitySettingsBinding = DataBindingUtil.setContentView(this, R.layout.activity_settings);
        presenter.getCountries();
        setConfirmButton();
    }

    private void setConfirmButton() {
        activitySettingsBinding.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                City city = (City) activitySettingsBinding.selectCity.getSelectedItem();
                if(city != null)
                    presenter.saveChosenCity(city);
                else
                    showMessage("Please select a city first");
            }
        });
    }

    @Override
    public void setPresenter(SettingsContractor.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showCountries(List<Country> countries) {
        ArrayAdapter<Country> adapter =
                new ArrayAdapter<Country>(this,
                        android.R.layout.simple_spinner_item,countries);
        activitySettingsBinding.selectCountry.setAdapter(adapter);
        activitySettingsBinding.selectCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Country selectedCountry = (Country)activitySettingsBinding.selectCountry.getAdapter().getItem(position);
                presenter.getCountriesCities(selectedCountry);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void showCities(List<City> cities) {
        ArrayAdapter<City> adapter =
                new ArrayAdapter<City>(this,
                        android.R.layout.simple_spinner_item,cities);
        activitySettingsBinding.selectCity.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        firstTime = true;
    }

    @Override
    public void goToMainPage() {
        startActivity(new Intent(this, DailyAcitivity.class));
        finish();
    }
}
