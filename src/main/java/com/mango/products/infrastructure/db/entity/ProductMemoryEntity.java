package com.mango.products.infrastructure.db.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ProductMemoryEntity {

    private UUID id;

    private String name;

    private String description;

    private PriceMemoryEntity price;

    private int version;

    private LocalDateTime createdAt;

    private Boolean active;
}
