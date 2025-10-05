package com.mango.products.infrastructure.rest.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductDto {

    private UUID id;

    private String name;

    private String description;

    private PriceDto price;

    private int version;

    private LocalDateTime createdAt;

    private Boolean active;
}
