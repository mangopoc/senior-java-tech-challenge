package com.mango.products.infrastructure.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductPricesDto {

    private String name;

    private String description;

    private List<PriceDto> prices;
}
