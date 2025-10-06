package com.mango.products.infrastructure.db.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class PriceMemoryEntity {

    private BigDecimal price;

    private Currency currency;

}
