package com.mango.products.application.usecase;

import com.mango.products.domain.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;


public interface FindPriceFromProductUseCase {
    Price findPriceAtDate(UUID id, LocalDate date);
}
