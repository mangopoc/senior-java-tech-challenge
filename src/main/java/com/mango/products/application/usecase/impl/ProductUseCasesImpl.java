package com.mango.products.application.usecase.impl;

import com.mango.products.application.port.PersistencePort;
import com.mango.products.application.usecase.AddPriceToProductUseCase;
import com.mango.products.application.usecase.CreateProductUseCase;
import com.mango.products.application.usecase.FindPriceFromProductUseCase;
import com.mango.products.domain.Price;
import com.mango.products.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ProductUseCasesImpl implements CreateProductUseCase, AddPriceToProductUseCase, FindPriceFromProductUseCase {

    @Autowired
    private PersistencePort persistencePort;

    @Override
    public void addPriceToProduct(UUID id, Price price) {
        Product product = persistencePort.findById(id);
        product.setPrice(price);
        persistencePort.update(product);
    }

    @Override
    public Product create(Product product) {
        return persistencePort.create(product);
    }

    @Override
    public Price findPriceAtDate(UUID id, LocalDate date) {
        return persistencePort.findPriceAtDate(id,date);
    }
}

