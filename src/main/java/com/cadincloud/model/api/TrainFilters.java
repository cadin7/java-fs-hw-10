package com.cadincloud.model.api;

public record TrainFilters(
        String locationId,
        String model,
        Integer minCarts,
        Integer maxCarts
) {
}
