package com.mango.products.infrastructure.db.adapter;

import com.mango.products.application.port.PersistencePort;
import com.mango.products.domain.Product;

import java.util.List;

public class PersistencyAdapter implements PersistencePort {

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }
}
