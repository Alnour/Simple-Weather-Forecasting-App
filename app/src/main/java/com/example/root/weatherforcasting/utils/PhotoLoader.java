package com.example.root.weatherforcasting.utils;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import android.databinding.BindingAdapter;


/**
 * Created by root on 23/06/17.
 */

public class PhotoLoader {
    public static void loadIcon(ImageView imageView, String iconId){
        loadPhoto(imageView, "http://openweathermap.org/img/w/" + iconId  + ".png");
    }

    @BindingAdapter("imageUrl")
    public static void loadPhoto(ImageView imageView, String path) {
        Log.i("path", "path = " + path);
        Glide.with(imageView.getContext())
                .load(path)
                .into(imageView);
    }
}
