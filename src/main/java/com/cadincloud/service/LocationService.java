package com.cadincloud.service;

import com.cadincloud.exceptions.ResourceNotFoundException;
import com.cadincloud.model.entity.LocationEntity;
import com.cadincloud.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository repository;

    public LocationEntity addLocation(LocationEntity entity) {
        return repository.save(entity);
    }

    public LocationEntity deleteLocation(String locationId) {
        final var locationToDelete = getOrThrow(locationId);

        repository.deleteById(locationId);

        return locationToDelete;
    }

    private LocationEntity getOrThrow(String locationId) {
        return repository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find location with id: " + locationId));
    }
}
