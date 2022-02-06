package com.example.fomodorobackend.location;

import com.example.fomodorobackend.User.User;
import com.example.fomodorobackend.User.UserService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;
import java.util.concurrent.ExecutionException;

public class LocationPOJO {
    @org.springframework.data.annotation.Id
    private int id;
    private String ownerUsername;
    private double latitude;
    private double longitude;
    private String description;
    private static int idCount = 1;
    private static final UserService userService = new UserService();

    public LocationPOJO(){this.id = ++idCount;}

    public LocationPOJO(double latitude, double longitude, String description, UserService userService) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.id = ++idCount;
    }

    public String getOwner() {
        return ownerUsername;
    }

    public void setOwner(String owner) {
        this.ownerUsername = owner;
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
