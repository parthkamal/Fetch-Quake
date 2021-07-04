package com.parth.quakereport;

public class earthquake {

    //creating a class of the object to which we want to make a custom adapter
    String magnitude;
    String url;

    public String getUrl() {
        return url;
    }

    String location,Date;

    public earthquake(String magnitude, String location, String date,String url) {
        this.magnitude = magnitude;
        this.location = location;
        Date = date;
        this.url =url;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return Date;
    }
}
