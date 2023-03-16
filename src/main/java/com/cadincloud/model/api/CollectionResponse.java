package com.cadincloud.model.api;

import java.util.List;

public record CollectionResponse<T>(List<T> content, PageInfo pageInfo) {
}
