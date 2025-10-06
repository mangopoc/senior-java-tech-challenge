package com.mango.products.infrastructure.db.mapper;


import com.mango.products.domain.Price;
import com.mango.products.infrastructure.db.entity.PriceMemoryEntity;
import com.mango.products.infrastructure.rest.dto.PriceCompleteDto;
import com.mango.products.infrastructure.rest.dto.PriceDto;
import com.mango.products.infrastructure.rest.dto.PriceValueDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Currency;

@Mapper(componentModel = "spring")
public interface PriceMemoryMapper {
    PriceMemoryEntity toEntity(Price  domain);
    Price toDomain(PriceMemoryEntity entity);
}
