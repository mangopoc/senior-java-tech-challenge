package com.mango.products.infrastructure.rest.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PriceDto {

    private BigDecimal value;

    private LocalDate initDate;

    private LocalDate endDate;


}
