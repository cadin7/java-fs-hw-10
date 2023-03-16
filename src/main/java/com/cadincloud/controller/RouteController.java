package com.cadincloud.controller;

import com.cadincloud.model.api.Route;
import com.cadincloud.model.mapper.RouteMapper;
import com.cadincloud.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("routes")
public class RouteController {

    private final RouteMapper mapper;
    private final RouteService service;

    @PostMapping
    Route addRoute(@RequestBody Route route) {
        return mapper.toApi(
                service.addRoute(
                        mapper.toEntity(route)));
    }
}
