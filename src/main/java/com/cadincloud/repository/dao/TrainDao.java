package com.cadincloud.repository.dao;

import com.cadincloud.model.api.TrainFilters;
import com.cadincloud.model.entity.TrainEntity;
import com.cadincloud.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class TrainDao {

    private final MongoTemplate mongo;
    private final TrainRepository repository;

    public Page<TrainEntity> findTrains(TrainFilters filters, Pageable pageable) {
        final var criteria = new Criteria();

        buildFilters(filters, criteria);

        final var query = Query.query(criteria).with(pageable);

        final var trains = mongo.find(query, TrainEntity.class);

        return PageableExecutionUtils.getPage(
                trains,
                pageable,
                () -> mongo.count(
                        query.limit(-1).skip(-1),
                        TrainEntity.class));
    }

    public TrainEntity saveTrain(TrainEntity entity) {
        return repository.save(entity);
    }

    public void deleteById(String trainId) {
        repository.deleteById(trainId);
    }

    public Optional<TrainEntity> findById(String trainId) {
        return repository.findById(trainId);
    }

    private void buildFilters(TrainFilters filters, Criteria criteria) {
        ofNullable(filters.locationId())
                .ifPresent(locationId -> criteria.and("locationId").is(locationId));
        ofNullable(filters.model())
                .ifPresent(model -> criteria.and("model").is(model));
        ofNullable(filters.minCarts())
                .ifPresent(minCarts -> criteria.and("carts").gte(minCarts));
        ofNullable(filters.maxCarts())
                .ifPresent(maxCarts -> criteria.and("carts").lte(maxCarts));
    }
}
