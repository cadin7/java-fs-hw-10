package com.cadincloud.model.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Train {

    private String id;

    private String model;

    private int carts;

    private String locationId;
}
