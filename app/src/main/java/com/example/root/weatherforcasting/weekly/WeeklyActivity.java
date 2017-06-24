package com.example.root.weatherforcasting.weekly;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.root.weatherforcasting.R;
import com.example.root.weatherforcasting.daily.DailyAcitivity;
import com.example.root.weatherforcasting.databinding.ActivityWeeklyBinding;
import com.example.root.weatherforcasting.factories.PresentersFactory;
import com.example.root.weatherforcasting.models.api_models.WeeklyResponse;
import com.example.root.weatherforcasting.settings.SettingsActivity;

public class WeeklyActivity extends AppCompatActivity implements WeeklyContractor.View{

    WeeklyContractor.Presenter presenter;
    ActivityWeeklyBinding activityWeeklyBinding;
    WeeklyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityWeeklyBinding = DataBindingUtil.setContentView
                (this, R.layout.activity_weekly);
        setPresenter(PresentersFactory.getWeeklyPresenter(this));
        presenter.getData();
        setListeners();
    }

    private void setListeners() {
        activityWeeklyBinding.goToDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDaily();
            }
        });
    }

    @Override
    public void setPresenter(WeeklyContractor.Presenter presenter) {
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
    public void showData(WeeklyResponse weeklyResponse) {
        activityWeeklyBinding.cityName.setText(weeklyResponse.getCity().getName());
        adapter = new WeeklyAdapter(weeklyResponse.getList(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        activityWeeklyBinding.weatherRv.setLayoutManager(layoutManager);
        activityWeeklyBinding.weatherRv.setAdapter(adapter);
    }

    @Override
    public void goToDaily() {
        startActivity(new Intent(this, DailyAcitivity.class));
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
    public void openSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }
}
