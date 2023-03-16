package com.cadincloud.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "trains")
public class TrainEntity {

    @Id
    private String id;

    private String model;

    private int carts;

    private String locationId;
}
