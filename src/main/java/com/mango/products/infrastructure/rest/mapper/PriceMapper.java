package com.mango.products.infrastructure.rest.mapper;


import com.mango.products.domain.Price;
import com.mango.products.infrastructure.rest.dto.PriceCompleteDto;
import com.mango.products.infrastructure.rest.dto.PriceDto;
import com.mango.products.infrastructure.rest.dto.PriceValueDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Currency;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(source = "currency", target = "currency", qualifiedByName = "stringToCurrency")
    Price toDomain(PriceCompleteDto dto);

    @Mapping(target = "currency", ignore = true)
    Price toDomain(PriceDto dto);

    PriceDto toDto(Price entity);

    @Named("stringToCurrency")
    static Currency stringToCurrency(String currencyCode) {
        return currencyCode != null ? Currency.getInstance(currencyCode) : null;
    }

    @Named("currencyToString")
    static String currencyToString(Currency currency) {
        return currency != null ? currency.getCurrencyCode() : null;
    }


    PriceValueDto toPriceValueDto(Price price);
}
