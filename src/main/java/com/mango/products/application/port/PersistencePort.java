package com.mango.products.application.port;

import com.mango.products.domain.Product;
import com.mango.products.infrastructure.rest.dto.ProductDto;

import java.util.List;

public interface PersistencePort {

    Product create(Product product);
    void update(Product product);
    List<Product> findAll();


}
