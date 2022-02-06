package com.example.fomodorobackend.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path = "/api/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping
    public LocationPOJO getUserInfo(@RequestParam String description) throws ExecutionException, InterruptedException {
        return locationService.getLocationInfo(description);
    }

    @PostMapping
    public String addLocation(@RequestBody LocationPOJO location) throws ExecutionException, InterruptedException {
        return locationService.saveLocationDetails(location);
    }

    @PutMapping
    public String updateOwner(@RequestParam("description") String description, @RequestParam("username") String username) throws ExecutionException, InterruptedException {
        return locationService.updateOwner(description, username);
    }


//    @PutMapping
//    public String updatePoints(@RequestBody LocationPOJO location) throws ExecutionException, InterruptedException {
//        return locationService.updateLocationDetails(location);
//    }

}
