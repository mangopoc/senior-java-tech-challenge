package com.mango.products.infrastructure.db.mapper;

import com.mango.products.domain.Price;
import com.mango.products.infrastructure.db.entity.PriceMemoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-06T08:59:41+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class PriceMemoryMapperImpl implements PriceMemoryMapper {

    @Override
    public PriceMemoryEntity toEntity(Price domain) {
        if ( domain == null ) {
            return null;
        }

        PriceMemoryEntity priceMemoryEntity = new PriceMemoryEntity();

        priceMemoryEntity.setCurrency( domain.getCurrency() );

        return priceMemoryEntity;
    }

    @Override
    public Price toDomain(PriceMemoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Price price = new Price();

        price.setCurrency( entity.getCurrency() );

        return price;
    }
}
