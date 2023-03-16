package com.cadincloud.model.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Location {

    private String id;

    private String city;
}
