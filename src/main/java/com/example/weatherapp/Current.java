package com.example.weatherfx;

import java.util.Arrays;

public class Current {

    public int temperature;
    public int wind_speed;
    public int humidity;
    public int uv_index;
    public int precip;
    public int feelslike;
    public String wind_dir;
    public String[] weather_descriptions;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getUv_index() {
        return uv_index;
    }

    public void setUv_index(int uv_index) {
        this.uv_index = uv_index;
    }

    public int getPrecip() {
        return precip;
    }

    public void setPrecip(int precip) {
        this.precip = precip;
    }

    public int getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(int feelslike) {
        this.feelslike = feelslike;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String[] getWeather_descriptions() {
        return weather_descriptions;
    }

    public void setWeather_descriptions(String[] weather_descriptions) {
        this.weather_descriptions = weather_descriptions;
    }

    public StringBuffer printWeatherDescriptions(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < weather_descriptions.length; i++) {
            sb.append(weather_descriptions[i]).append(" ");
        }
        return sb;
    }

    @Override
    public String toString() {
        return "Temperature : " + temperature + "ºF" + "\n" +
                "Wind Speed : " + wind_speed + " mph" + "\n" +
                "Humidity : " + humidity + "%" + "\n" +
                "UV Index : " + uv_index + "\n" +
                "Precipitation : " + precip + "%" + "\n" +
                "Feels Like : " + feelslike + "ºF" + "\n" +
                "Wind Direction : " + wind_dir + "\n" +
                "Weather Descriptions : " + Arrays.toString(weather_descriptions);
    }
}
