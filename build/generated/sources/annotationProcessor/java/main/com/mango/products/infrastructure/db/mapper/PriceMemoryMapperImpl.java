package com.mango.products.infrastructure.db.mapper;

import com.mango.products.domain.Price;
import com.mango.products.infrastructure.db.entity.PriceMemoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-07T22:07:26+0200",
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

        priceMemoryEntity.setValue( domain.getValue() );
        priceMemoryEntity.setCurrency( domain.getCurrency() );
        priceMemoryEntity.setInitDate( domain.getInitDate() );
        priceMemoryEntity.setEndDate( domain.getEndDate() );

        return priceMemoryEntity;
    }

    @Override
    public Price toDomain(PriceMemoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Price price = new Price();

        price.setValue( entity.getValue() );
        price.setCurrency( entity.getCurrency() );
        price.setInitDate( entity.getInitDate() );
        price.setEndDate( entity.getEndDate() );

        return price;
    }
}
