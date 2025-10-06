package com.mango.products.infrastructure.rest.dto;

import com.mango.products.infrastructure.rest.annotation.ValidDateRange;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@ValidDateRange
@Data
public class PriceDto {

    @NotNull
    @Positive
    private BigDecimal value;

    @NotNull
    private LocalDate initDate;

    private LocalDate endDate;


}
