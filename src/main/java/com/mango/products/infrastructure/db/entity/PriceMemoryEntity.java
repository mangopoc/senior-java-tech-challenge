package com.mango.products.infrastructure.db.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@Data
public class PriceMemoryEntity {

    private BigDecimal value;

    private Currency currency;

    @NotNull
    private LocalDate initDate;

    private LocalDate endDate;


}
