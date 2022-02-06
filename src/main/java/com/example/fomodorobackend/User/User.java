package com.example.fomodorobackend.User;

import com.example.fomodorobackend.location.LocationPOJO;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;

    private String password;

    private int points;

    private int locationOwnershipId;

    private List<String> ownedLocations;

    public User(){
        this.ownedLocations = new ArrayList<String>();
    }

//public User(String username, String password, int points){
//    this.username = username;
//    this.password = password;
//    this.points = points;
//}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0;
        this.ownedLocations = new ArrayList<String>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLocationOwnershipId() {
        return locationOwnershipId;
    }

    public void setLocationOwnershipId(int locationOwnershipId) {
        this.locationOwnershipId = locationOwnershipId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<String> getOwnedLocations() {
        return ownedLocations;
    }

    public void setOwnedLocations(List<String> ownedLocations) {
        this.ownedLocations = ownedLocations;
    }

    public void addOwnedLocations(String newLocation) {
        this.ownedLocations.add(newLocation);
    }

    public boolean deleteOwnedLocation(String nameOfLocation) {
        return this.ownedLocations.remove(nameOfLocation); //maybe add error checking? test first
    }
}
