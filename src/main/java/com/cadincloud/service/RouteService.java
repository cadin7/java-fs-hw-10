package com.cadincloud.service;

import com.cadincloud.model.entity.RouteEntity;
import com.cadincloud.repository.RouteRepository;
import com.cadincloud.service.validator.RouteValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteValidator validator;
    private final RouteRepository repository;
    public RouteEntity addRoute(RouteEntity entity) {
        validator.validateNewOrThrow(entity);

        return repository.save(entity);
    }
}
