package com.cadincloud.repository;

import com.cadincloud.model.entity.TrainEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainRepository extends MongoRepository<TrainEntity, String> {
}
