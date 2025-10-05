package com.mango.products.infrastructure.rest.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PriceCompleteDto {

    private BigDecimal value;

    private String currency;

    private LocalDate initDate;

    private LocalDate endDate;

}
