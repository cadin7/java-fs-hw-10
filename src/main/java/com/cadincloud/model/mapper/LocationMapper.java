package com.cadincloud.model.mapper;

import com.cadincloud.model.api.Location;
import com.cadincloud.model.entity.LocationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location toApi(LocationEntity entity);

    LocationEntity toEntity(Location train);
}
