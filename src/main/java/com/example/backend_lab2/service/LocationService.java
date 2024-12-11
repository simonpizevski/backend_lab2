package com.example.backend_lab2.service;

import com.example.backend_lab2.dto.LocationDTO;
import com.example.backend_lab2.entity.Location;
import com.example.backend_lab2.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.geolatte.geom.G2D;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDTO> getAllPublicLocations() {
        List<Location> locations = locationRepository.findAllPublicLocations();
        return locations.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<LocationDTO> getPublicLocationsByCategory(Long categoryId) {
        List<Location> locations = locationRepository.findByCategoryId(categoryId);
        return locations.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<LocationDTO> getAllByUserId(String userId) {
        List<Location> locations = locationRepository.findAllByUserId(userId);
        return locations.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<LocationDTO> getLocationsWithinRadius(Point<G2D> center, double radius) {
        List<Location> locations = locationRepository.findAllWithinRadius(center, radius);
        return locations.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = toEntity(locationDTO);
        Location savedLocation = locationRepository.save(location);
        return toDTO(savedLocation);
    }

    public LocationDTO updateLocation(Long id, LocationDTO locationDTO) {
        Location existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found!"));

        existingLocation.setName(locationDTO.getName());
        existingLocation.setDescription(locationDTO.getDescription());
        existingLocation.setPublic(locationDTO.isPublic());
        existingLocation.setCategoryId(locationDTO.getCategoryId());
        existingLocation.setLastModified(Timestamp.valueOf(locationDTO.getLastModified()).toLocalDateTime());

        Location updatedLocation = locationRepository.save(existingLocation);
        return toDTO(updatedLocation);
    }

    public void softDeleteLocation(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found!"));
        location.setDeleted(true);
        locationRepository.save(location);
    }

    private LocationDTO toDTO(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setId(location.getId());
        dto.setName(location.getName());
        dto.setUserId(location.getUserId());
        dto.setPublic(location.isPublic());
        dto.setDescription(location.getDescription());
        dto.setCategoryId(location.getCategoryId());
        dto.setCoordinate(location.getCoordinate().toString());
        dto.setCreatedAt(location.getCreatedAt());
        dto.setLastModified(location.getLastModified());
        return dto;
    }

    private Location toEntity(LocationDTO dto) {
        Location location = new Location();
        location.setId(dto.getId());
        location.setName(dto.getName());
        location.setDescription(dto.getDescription());
        location.setPublic(dto.isPublic());
        location.setUserId(dto.getUserId());
        location.setCategoryId(dto.getCategoryId());
        return location;
    }
}