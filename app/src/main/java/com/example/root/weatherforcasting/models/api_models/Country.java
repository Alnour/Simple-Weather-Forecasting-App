package com.example.root.weatherforcasting.models.api_models;

import java.util.List;

/**
 * Created by root on 24/06/17.
 */

public class Country {
    String name;
    int id;


    public Country(int id, String name){
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

}
