package com.example.fomodorobackend.location;

import com.example.fomodorobackend.User.User;
import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;

public class LocationPOJO {
    @org.springframework.data.annotation.Id
    private int id;
    private double latitude;
    private double longitude;
    private String description;
    private String usernameOwner;
    private static int idCount = 1;

    public LocationPOJO(){this.id = ++idCount;}

    public LocationPOJO(double latitude, double longitude, String description) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.id = ++idCount;
    }

    public String getUsernameOwner() {
        return usernameOwner;
    }

    public void setUsernameOwner(String usernameOwner) {
        this.usernameOwner = usernameOwner;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
