package com.cadincloud.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "routes")
public class RouteEntity {

    @Id
    private String id;

    private String startLocationId;

    private String destinationLocationId;

    private String length;

    private String trainId;
}
