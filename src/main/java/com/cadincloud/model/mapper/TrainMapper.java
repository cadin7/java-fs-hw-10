package com.cadincloud.model.mapper;

import com.cadincloud.model.api.Train;
import com.cadincloud.model.entity.TrainEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainMapper {

    Train toApi(TrainEntity entity);

    TrainEntity toEntity(Train train);

    List<Train> toApi(List<TrainEntity> trainEntities);
}
