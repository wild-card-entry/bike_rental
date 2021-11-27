package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BikeController {
    @Autowired
    private BikeRepository bikeRepository;
    @Autowired
    private LocationRepository locationRepository;
    @PostMapping(path="/addNewBikes")
    public
    String addBike(@RequestParam String bikeName, @RequestParam String bikeColor, @RequestParam String currentLocation) {
        Bike bike = new Bike();
        bike.setModel(bikeName);
        bike.setColor(bikeColor);
        bike.setCurrentLocation(locationRepository.findLocationByAddress(currentLocation));
        bike.setAvailable(true);
        bikeRepository.save(bike);
        return "redirect:/";
    }

    @PostMapping(path="/addNewLocation")
    public
    String addLocation(@RequestParam String locationName,@RequestParam String locationPhone) {
        Location location = new Location();
        location.setAddress(locationName);
        location.setPhone(locationPhone);
        locationRepository.save(location);
        return "redirect:/";
    }
}

