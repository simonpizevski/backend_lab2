package com.example.backend_lab2.service;

import com.example.backend_lab2.dto.LocationDTO;
import com.example.backend_lab2.entity.Location;
import com.example.backend_lab2.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private LocationRepository repository;

    public List<LocationDTO> getAllPublicLocations() {
        return repository.findByIsPublicTrue()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<LocationDTO> getLocationsByCategory(Long categoryId) {
        return repository.findByCategoryIdAndIsPublic(categoryId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<LocationDTO> getUserLocations(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public LocationDTO createLocation(LocationDTO dto) {
        Location location = new Location();
        location.setName(dto.getName());
        location.setIsPublic(dto.getIsPublic());
        location.setCoordinate(dto.getCoordinate());
        location.setDescription(dto.getDescription());
        location.setCreatedAt(LocalDateTime.now());
        Location saved = repository.save(location);
        return convertToDTO(saved);
    }

    private LocationDTO convertToDTO(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setId(location.getId());
        dto.setName(location.getName());
        dto.setCategoryId(location.getCategory().getId());
        dto.setIsPublic(location.getIsPublic());
        dto.setCoordinate(location.getCoordinate());
        dto.setDescription(location.getDescription());
        return dto;
    }
}
