package com.mango.products.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Product {

    private UUID id;

    private String name;

    private String description;

    private Price price;

    private int version;

    private LocalDateTime createdAt;

    private Boolean active;
}
