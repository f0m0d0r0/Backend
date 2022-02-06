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
    public String registerUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.saveUserDetails(user);
    }

    @PutMapping("/points")
    public String updatePoints(@RequestParam("username") String username, @RequestParam("points") int points) throws ExecutionException, InterruptedException {
        return userService.updateUserPoints(username, points);
    }

    @PutMapping("/location")
    public String updateOwnedLocations(@RequestParam("username") String username, @RequestParam("location") String location) throws ExecutionException, InterruptedException {
        return userService.addUserOwnedLocations(username, location);
    }

    @DeleteMapping
    public String deleteLocation(@RequestParam("username") String username, @RequestParam("location") String deleteLoc) throws ExecutionException, InterruptedException {
        return userService.deleteUserOwnedLocation(username, deleteLoc);
    }

}
