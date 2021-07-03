package com.parth.quakereport;

public class earthquake {

    //creating a class of the object to which we want to make a custom adapter
    int magnitude;
    String location,Date;

    public earthquake(int magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        Date = date;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return Date;
    }
}
