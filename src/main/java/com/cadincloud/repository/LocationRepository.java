package com.cadincloud.repository;

import com.cadincloud.model.entity.LocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<LocationEntity, String> {
}
