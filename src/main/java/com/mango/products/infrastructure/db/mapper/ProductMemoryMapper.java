package com.mango.products.infrastructure.db.mapper;

import com.mango.products.domain.Product;
import com.mango.products.infrastructure.db.entity.ProductMemoryEntity;
import com.mango.products.infrastructure.rest.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PriceMemoryMapper.class})
public interface ProductMemoryMapper {

    ProductMemoryEntity toEntity(Product product);

    Product toDomain(ProductMemoryEntity entity);
}