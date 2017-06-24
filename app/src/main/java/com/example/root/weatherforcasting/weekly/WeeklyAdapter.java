package com.example.root.weatherforcasting.weekly;

import android.content.Context;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.root.weatherforcasting.databinding.WeeklyItemBinding;
import com.example.root.weatherforcasting.models.api_models.List;
import com.example.root.weatherforcasting.utils.PhotoLoader;
import com.example.root.weatherforcasting.utils.TimeUtil;

/**
 * Created by root on 24/06/17.
 */

class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.ViewHolder>{
    private java.util.List<List> items;
    private Context context;

    public WeeklyAdapter(java.util.List<List> items, Context context){
        this.items = items;
        this.context = context;
    }
    @Override
    public WeeklyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        WeeklyItemBinding itemBinding =
                WeeklyItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(WeeklyAdapter.ViewHolder holder, int position) {
        holder.bind(items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        WeeklyItemBinding weeklyItemBinding;

        public ViewHolder(WeeklyItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.weeklyItemBinding = itemBinding;
        }
        public void bind(List dayItem, int pos){
            weeklyItemBinding.evening.setText("Evening: " + dayItem.getTemp().getEve()+ "°");
            weeklyItemBinding.morning.setText("Morning: " + dayItem.getTemp().getMorn() + "°");
            weeklyItemBinding.temp.setText(dayItem.getTemp().getDay() + "°");
            weeklyItemBinding.maxMin.setText(dayItem.getTemp().getMin()+"°/" +
            dayItem.getTemp().getMax() + "°");
            weeklyItemBinding.dayOfWeek.setText(getDay(dayItem, pos));
            PhotoLoader.loadIcon(weeklyItemBinding.icon, dayItem.getWeather().get(0).getIcon());
            weeklyItemBinding.executePendingBindings();

        }
    }

    @NonNull
    private String getDay(List dayItem, int pos) {
        return TimeUtil.dayStringFormat(dayItem.getDt() + pos * ONE_DAY());
    }

    private int ONE_DAY() {
        return 1000 * 60 * 60 * 24;
    }
}
