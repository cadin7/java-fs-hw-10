package com.cadincloud.service;

import com.cadincloud.exceptions.ResourceNotFoundException;
import com.cadincloud.model.api.TrainFilters;
import com.cadincloud.model.entity.TrainEntity;
import com.cadincloud.repository.dao.TrainDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainService {

    private final TrainDao dao;
    private final ObjectMapper mapper;

    public Page<TrainEntity> getTrains(TrainFilters filters, Pageable pageable) {
        return dao.findTrains(filters, pageable);
    }

    public TrainEntity addTrain(TrainEntity entity) {
        return dao.saveTrain(entity);
    }

    public TrainEntity deleteTrain(String trainId) {
        final var trainToDelete = getOrThrow(trainId);

        dao.deleteById(trainId);

        return trainToDelete;
    }

    @SneakyThrows
    public TrainEntity patchTrain(String trainId, JsonPatch patch) {
        final var dbTrain = getOrThrow(trainId);
        final var patchedJson = patch.apply(mapper.valueToTree(dbTrain));
        final var patchedTrainEntity = mapper.treeToValue(patchedJson, TrainEntity.class);

        return replaceTrain(trainId, patchedTrainEntity);
    }

    public TrainEntity getOrThrow(String trainId) {
        return dao.findById(trainId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find train with id: " + trainId));
    }

    private TrainEntity replaceTrain(String trainId, TrainEntity patchedTrainEntity) {
        patchedTrainEntity.setId(trainId);

        return dao.saveTrain(patchedTrainEntity);
    }
}
