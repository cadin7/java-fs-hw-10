package com.cadincloud.service.validator;

import com.cadincloud.exceptions.ValidationException;
import com.cadincloud.model.entity.RouteEntity;
import com.cadincloud.repository.LocationRepository;
import com.cadincloud.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import static java.lang.String.join;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
public class RouteValidator {

    private final TrainService trainService;
    private final LocationRepository locationRepository;

    public void validateNewOrThrow(RouteEntity route) {
        validate(route)
                .ifPresent(validationException -> {
                    throw validationException;
                });
    }

    private Optional<ValidationException> validate(RouteEntity route) {
        final var errorMessages = new ArrayList<String>();

        if (locationDoesntExists(route.getStartLocationId())) {
            errorMessages.add("Route start location doesn't exists!");
        } else if (locationDoesntExists(route.getDestinationLocationId())) {
            errorMessages.add("Route destination location doesn't exists!");
        } else if (!isTrainAtStartLocation(route)) {
            errorMessages.add("Train is not at the start location!");
        }
        return errorMessages.isEmpty()
                ? empty()
                : of(new ValidationException(join(",", errorMessages)));
    }

    private boolean locationDoesntExists(String locationId) {
        return !locationRepository.existsById(locationId);
    }

    private boolean isTrainAtStartLocation(RouteEntity route) {
        return Objects.equals(
                route.getStartLocationId(),
                trainService.getOrThrow(route.getTrainId()).getLocationId());
    }
}
