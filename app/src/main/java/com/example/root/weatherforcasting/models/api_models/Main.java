
package com.example.root.weatherforcasting.models.api_models;


public class Main {

    private float temp;
    private String pressure;
    private String humidity;
    private String tempMin;
    private String tempMax;

    public int getTemp() {
        return Math.round(temp);
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

}
