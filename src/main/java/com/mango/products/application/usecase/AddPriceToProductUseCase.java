package com.mango.products.application.usecase;

import com.mango.products.domain.Price;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface AddPriceToProductUseCase {
    void addPriceToProduct(UUID id, Price price);
}
