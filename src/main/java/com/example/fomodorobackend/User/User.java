package com.example.fomodorobackend.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private long id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private int points;


    public User(long id, String username, String password, int points) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.points = points;
    }
}
