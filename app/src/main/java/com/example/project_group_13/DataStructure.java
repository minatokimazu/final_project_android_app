package com.example.project_group_13;

public class DataStructure {
    private double Temperature;
    private double Humidity;
    private double UV;
    private long timestamp;
    private double Light;

    public DataStructure(){

    }

    public DataStructure(double temperature, double humidity, double UV, long timestamp, double light) {
        Temperature = temperature;
        Humidity = humidity;
        this.UV = UV;
        this.timestamp = timestamp;
        Light = light;
    }

    public double getTemperature() {
        return Temperature;
    }

    public void setTemperature(double temperature) {
        Temperature = temperature;
    }

    public double getHumidity() {
        return Humidity;
    }

    public void setHumidity(double humidity) {
        Humidity = humidity;
    }

    public double getUV() {
        return UV;
    }

    public void setUV(double UV) {
        this.UV = UV;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getLight() {
        return Light;
    }

    public void setLight(double light) {
        Light = light;
    }
}

