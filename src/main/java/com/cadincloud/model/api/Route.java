package com.cadincloud.model.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Route {

    private String id;

    private String startLocationId;

    private String destinationLocationId;

    private String length;

    private String trainId;
}
