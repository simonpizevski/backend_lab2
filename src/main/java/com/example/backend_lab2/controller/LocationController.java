package com.example.backend_lab2.controller;

import com.example.backend_lab2.dto.LocationDTO;
import com.example.backend_lab2.service.LocationService;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;
    private final GeometryFactory geometryFactory;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
        this.geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
    }

    @GetMapping("/public")
    public ResponseEntity<List<LocationDTO>> getAllPublicLocations() {
        return ResponseEntity.ok(locationService.getAllPublicLocations());
    }

    @GetMapping("/public/category/{categoryId}")
    public ResponseEntity<List<LocationDTO>> getPublicLocationsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(locationService.getPublicLocationsByCategory(categoryId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LocationDTO>> getAllByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(locationService.getAllByUserId(userId));
    }

    @GetMapping("/radius")
    public ResponseEntity<List<LocationDTO>> getLocationsWithinRadius(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double radius) {

        return ResponseEntity.ok(locationService.getLocationsWithinRadius(latitude, longitude, radius));
    }

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        return new ResponseEntity<>(locationService.createLocation(locationDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable Long id, @RequestBody LocationDTO locationDTO) {
        return ResponseEntity.ok(locationService.updateLocation(id, locationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        locationService.softDeleteLocation(id);
        return ResponseEntity.noContent().build();
    }
}


