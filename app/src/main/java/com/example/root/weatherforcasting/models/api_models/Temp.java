
package com.example.root.weatherforcasting.models.api_models;


public class Temp {

    private Float day;
    private Float min;
    private Float max;
    private Float night;
    private Float eve;
    private Float morn;

    public float getDay() {
        return Math.round(day) - 273;
    }

    public void setDay(Float day) {
        this.day = day;
    }

    public float getMin() {
        return Math.round(min) -273;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public float getMax() {
        return Math.round(max) -273;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getNight() {
        return night;
    }

    public void setNight(Float night) {
        this.night = night;
    }

    public float getEve() {
        return Math.round(eve) - 273;
    }

    public void setEve(Float eve) {
        this.eve = eve;
    }

    public float getMorn() {
        return Math.round(morn) -273;
    }

    public void setMorn(Float morn) {
        this.morn = morn;
    }

}
