package com.cadincloud.controller;

import com.cadincloud.model.api.CollectionResponse;
import com.cadincloud.model.api.PageInfo;
import com.cadincloud.model.api.Train;
import com.cadincloud.model.api.TrainFilters;
import com.cadincloud.model.mapper.TrainMapper;
import com.cadincloud.service.TrainService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("trains")
public class TrainController {

    private final TrainMapper mapper;
    private final TrainService service;

    @GetMapping
    CollectionResponse<Train> getTrains(TrainFilters filters, Pageable pageable) {
        final var trains = service.getTrains(filters, pageable);

        return new CollectionResponse<>(
                mapper.toApi(trains.getContent()),
                new PageInfo(
                        trains.getTotalPages(),
                        trains.getTotalElements(),
                        pageable.getPageNumber(),
                        pageable.getPageSize()));
    }

    @PostMapping
    Train addTrain(@RequestBody Train train) {
        return mapper.toApi(
                service.addTrain(
                        mapper.toEntity(train)));
    }

    @DeleteMapping("{trainId}")
    Train deleteTrain(@PathVariable String trainId) {
        return mapper.toApi(
                service.deleteTrain(trainId));
    }

    @PatchMapping("{trainId}")
    Train patchTrain(@PathVariable String trainId, @RequestBody JsonPatch patch) {
        return mapper.toApi(
                service.patchTrain(trainId, patch));
    }
}
