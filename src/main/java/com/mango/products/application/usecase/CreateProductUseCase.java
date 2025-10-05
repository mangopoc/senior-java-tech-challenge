package com.mango.products.application.usecase;

import com.mango.products.domain.Product;
import org.springframework.stereotype.Service;


public interface CreateProductUseCase {
    Product  create(Product product);
}
