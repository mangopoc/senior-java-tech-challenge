package com.mango.products.infrastructure.rest.mapper;

import com.mango.products.domain.Product;
import com.mango.products.infrastructure.rest.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PriceMapper.class})
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toDomain(ProductDto dto);
}