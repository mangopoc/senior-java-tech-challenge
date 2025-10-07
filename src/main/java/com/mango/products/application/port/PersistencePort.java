package com.mango.products.application.port;

import com.mango.products.domain.Price;
import com.mango.products.domain.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PersistencePort {

    Product create(Product product);

    void update(Product product);

    List<Product> findAll();

    Product findById(UUID id);

    Price findPriceAtDate(UUID id, LocalDate date);

}
