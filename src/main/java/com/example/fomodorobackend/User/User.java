package com.example.fomodorobackend.User;

import org.springframework.data.annotation.Id;

public class User {

    private String username;

    private String password;

    private int points;

    private int locationOwnershipId;

    public User(){}

//public User(String username, String password, int points){
//    this.username = username;
//    this.password = password;
//    this.points = points;
//}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0;
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
}
