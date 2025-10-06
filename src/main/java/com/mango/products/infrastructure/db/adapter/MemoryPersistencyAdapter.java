package com.mango.products.infrastructure.db.adapter;

import com.mango.products.application.port.PersistencePort;
import com.mango.products.domain.Product;
import com.mango.products.infrastructure.db.entity.ProductMemoryEntity;
import com.mango.products.infrastructure.db.mapper.PriceMemoryMapper;
import com.mango.products.infrastructure.db.mapper.ProductMemoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class MemoryPersistencyAdapter implements PersistencePort {
    private static Map<UUID, List<ProductMemoryEntity>> products = new HashMap<>();

    @Autowired
    private ProductMemoryMapper productMapper;
    @Autowired
    private PriceMemoryMapper priceMapper;

    @Override
    public Product create(Product product) {
        product.setId(UUID.randomUUID());
        product.setActive(true);
        product.setCreatedAt(LocalDateTime.now());
        product.setVersion(1);
        List<ProductMemoryEntity> versions = new ArrayList<>();
        versions.add(productMapper.toEntity(product));
        products.put(product.getId(), versions);
        return product;
    }

    @Override
    public void update(Product product) {
        List<ProductMemoryEntity> productHistory = products.get(product.getId());

        if (productHistory != null && !productHistory.isEmpty()) {
            ProductMemoryEntity storeProduct = productHistory.get(productHistory.size() - 1);
            storeProduct.setActive(false);

            ProductMemoryEntity newVersionProduct = new ProductMemoryEntity();
            newVersionProduct.setId(storeProduct.getId());
            newVersionProduct.setName(product.getName());
            newVersionProduct.setDescription(product.getDescription());
            newVersionProduct.setPrice(priceMapper.toEntity(product.getPrice()));
            newVersionProduct.setVersion(storeProduct.getVersion() + 1);
            newVersionProduct.setActive(true);
            newVersionProduct.setCreatedAt(LocalDateTime.now());
            productHistory.add(newVersionProduct);

        } else {
            create(product);
        }
    }

    @Override
    public List<Product> findAll() {
        return products.values().stream()
                .filter(productHistory -> productHistory != null && !productHistory.isEmpty())
                .map(productHistory -> productMapper.toDomain(productHistory.get(productHistory.size() - 1)))
                .collect(Collectors.toList());

    }

    @Override
    public Product findById(UUID id) {
                List<ProductMemoryEntity> history = products.get(id);

        Product domainProduct = null;
        if (history != null && !history.isEmpty()) {
            ProductMemoryEntity latest = history.get(history.size() - 1);
            domainProduct = productMapper.toDomain(latest);
            // usar domainProduct aquí
        }
        return domainProduct;

    }
}
