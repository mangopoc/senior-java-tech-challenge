package com.mango.products.infrastructure.rest.mapper;

import com.mango.products.domain.Price;
import com.mango.products.infrastructure.rest.dto.PriceCompleteDto;
import com.mango.products.infrastructure.rest.dto.PriceDto;
import com.mango.products.infrastructure.rest.dto.PriceValueDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-05T10:14:17+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public Price toDomain(PriceCompleteDto dto) {
        if ( dto == null ) {
            return null;
        }

        Price price = new Price();

        price.setCurrency( PriceMapper.stringToCurrency( dto.getCurrency() ) );
        price.setValue( dto.getValue() );
        price.setInitDate( dto.getInitDate() );
        price.setEndDate( dto.getEndDate() );

        return price;
    }

    @Override
    public Price toDomain(PriceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Price price = new Price();

        price.setValue( dto.getValue() );
        price.setInitDate( dto.getInitDate() );
        price.setEndDate( dto.getEndDate() );

        return price;
    }

    @Override
    public PriceDto toDto(Price entity) {
        if ( entity == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        priceDto.setValue( entity.getValue() );
        priceDto.setInitDate( entity.getInitDate() );
        priceDto.setEndDate( entity.getEndDate() );

        return priceDto;
    }

    @Override
    public PriceValueDto toPriceValueDto(Price price) {
        if ( price == null ) {
            return null;
        }

        PriceValueDto priceValueDto = new PriceValueDto();

        priceValueDto.setValue( price.getValue() );

        return priceValueDto;
    }
}
