package com.example.root.weatherforcasting.daily;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.root.weatherforcasting.R;
import com.example.root.weatherforcasting.databinding.ActivityMainBinding;
import com.example.root.weatherforcasting.factories.PresentersFactory;
import com.example.root.weatherforcasting.models.api_models.CityResponse;
import com.example.root.weatherforcasting.settings.SettingsActivity;
import com.example.root.weatherforcasting.utils.PhotoLoader;
import com.example.root.weatherforcasting.weekly.WeeklyActivity;


public class DailyAcitivity extends AppCompatActivity implements DailyContractor.View{

    private ActivityMainBinding bindingObject;
    private DailyContractor.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingObject = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setPresenter(PresentersFactory.getDailyPresenter(this));
        presenter.getData();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setListeners();


    }

    private void setListeners() {
        bindingObject.content.goToWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeeklyForecast();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            openSettings();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(DailyContractor.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(CityResponse response) {
        bindingObject.setForecast(response);
        bindingObject.content.cityName.setText(bindingObject.getForecast().getName());
        bindingObject.content.weatherName.setText(bindingObject.getForecast().getWeather().get(0).getMain());
        bindingObject.content.temperature.setText((bindingObject.getForecast().getMain().getTemp() - 273)  + "°");
        bindingObject.content.humidity.setText(bindingObject.getForecast().getMain().getHumidity()  + "%");
        PhotoLoader.loadIcon(bindingObject.content.weatherIcon, bindingObject.getForecast().getWeather().get(0).getIcon());
    }

    @Override
    public void openSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    @Override
    public void openWeeklyForecast() {
        startActivity(new Intent(this, WeeklyActivity.class));
    }
}
