package com.cadincloud.model.mapper;

import com.cadincloud.model.api.Route;
import com.cadincloud.model.entity.RouteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RouteMapper {

    Route toApi(RouteEntity entity);

    RouteEntity toEntity(Route route);
}
