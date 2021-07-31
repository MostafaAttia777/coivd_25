package com.MostafaCovied.Mostafacovied.Ministry;

public class Healthy_model {

    private String name;
    private String id;
    private double Latitude;
    private double Longitude;
    private String image;

    private double accuracy;
    private double elapsedRealtimeNanos;
    private double elapsedRealtimeUncertaintyNanos;
    private double provider;
    private double speed;

    public Healthy_model(String name, String id, double latitude, double longitude, String image, double accuracy, double elapsedRealtimeNanos, double speed, double time) {
        this.name = name;
        this.id = id;
        Latitude = latitude;
        Longitude = longitude;
        this.image = image;
        this.accuracy = accuracy;
        this.elapsedRealtimeNanos = elapsedRealtimeNanos;
        this.speed = speed;
        this.time = time;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getElapsedRealtimeNanos() {
        return elapsedRealtimeNanos;
    }

    public void setElapsedRealtimeNanos(double elapsedRealtimeNanos) {
        this.elapsedRealtimeNanos = elapsedRealtimeNanos;
    }

    public double getElapsedRealtimeUncertaintyNanos() {
        return elapsedRealtimeUncertaintyNanos;
    }

    public void setElapsedRealtimeUncertaintyNanos(double elapsedRealtimeUncertaintyNanos) {
        this.elapsedRealtimeUncertaintyNanos = elapsedRealtimeUncertaintyNanos;
    }

    public double getProvider() {
        return provider;
    }

    public void setProvider(double provider) {
        this.provider = provider;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeedAccuracyMetersPerSecond() {
        return speedAccuracyMetersPerSecond;
    }

    public void setSpeedAccuracyMetersPerSecond(double speedAccuracyMetersPerSecond) {
        this.speedAccuracyMetersPerSecond = speedAccuracyMetersPerSecond;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getVerticalAccuracyMeters() {
        return verticalAccuracyMeters;
    }

    public void setVerticalAccuracyMeters(double verticalAccuracyMeters) {
        this.verticalAccuracyMeters = verticalAccuracyMeters;
    }



    private double speedAccuracyMetersPerSecond;
    private double time;
    private double verticalAccuracyMeters;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Healthy_model() {
    }

    public Healthy_model(String name, String id, double latitude, double longitude, String image) {
        this.name = name;
        this.id = id;
        Latitude = latitude;
        Longitude = longitude;
        this.image = image;
    }
}
