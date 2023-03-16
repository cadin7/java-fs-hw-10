package com.cadincloud.controller;

import com.cadincloud.model.api.Location;
import com.cadincloud.model.mapper.LocationMapper;
import com.cadincloud.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("locations")
public class LocationController {

    private final LocationMapper mapper;
    private final LocationService service;

    @PostMapping
    Location addLocation(@RequestBody Location location) {
        return mapper.toApi(
                service.addLocation(
                        mapper.toEntity(location)));
    }

    @DeleteMapping("{locationId}")
    Location deleteLocation(@PathVariable String locationId) {
        return mapper.toApi(
                service.deleteLocation(locationId));
    }
}
