package com.cadincloud.repository;

import com.cadincloud.model.entity.RouteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<RouteEntity, String> {
}
