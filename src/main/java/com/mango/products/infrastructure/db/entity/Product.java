package com.mango.products.infrastructure.db.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Product {

    private UUID id;

    private String name;

    private Price price;

    private int version;

    private LocalDateTime createdAt;

    private Boolean active;
}
