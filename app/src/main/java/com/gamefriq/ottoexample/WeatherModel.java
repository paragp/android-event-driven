package com.gamefriq.ottoexample;

/** Weather Definition
 * Created by oyewale on 7/15/15.
 */
public class WeatherModel {
    private int temperature;
    private String location;

    public WeatherModel(int temperature, String location) {
        this.temperature = temperature;
        this.location = location;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }

    public static WeatherModel getDummyCityWeather(int id){
        switch (id){
            case 0:
                return new WeatherModel(33, "Lagos");
            case 1:
                return new WeatherModel(12, "San Francisco");
            case 2:
                return new WeatherModel(18, "London");
            case 3:
                return new WeatherModel(15, "Nairobi");
            default:
                return new WeatherModel(34, "Ile-Ife");

        }
    }
}
