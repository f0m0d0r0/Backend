package com.example.fomodorobackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public User getUserInfo(@RequestParam String username) throws ExecutionException, InterruptedException {
        return userService.getUserInfo(username);
    }

    @PostMapping
    public void registerUser(@RequestParam String username, @RequestParam String password) {}

    @PutMapping
    public String updateUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.updateUserDetails(user);
    }
}
