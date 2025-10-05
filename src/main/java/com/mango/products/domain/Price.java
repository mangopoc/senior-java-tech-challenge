package com.mango.products.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@Data
public class Price {

    private BigDecimal value;

    private Currency currency;


    private LocalDate initDate;

    private LocalDate endDate;


}
