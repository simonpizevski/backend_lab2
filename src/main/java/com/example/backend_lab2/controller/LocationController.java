package com.example.backend_lab2.controller;

import com.example.backend_lab2.dto.LocationDTO;
import com.example.backend_lab2.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private LocationService locationService;

    @GetMapping("/public")
    public List<LocationDTO> getAllPublicLocations() {
        return locationService.getAllPublicLocations();
    }

    @GetMapping("/category/{id}")
    public List<LocationDTO> getLocationsByCategory(@PathVariable Long categoryId) {
        return locationService.getLocationsByCategory(categoryId);
    }

    @GetMapping("/user/{userId}")
    public List<LocationDTO> getUserLocations(@PathVariable Long userId) {
        return locationService.getUserLocations(userId);
    }

    @PostMapping
    public LocationDTO createLocation(@RequestBody LocationDTO locationDTO) {
        return locationService.createLocation(locationDTO);
    }
}
