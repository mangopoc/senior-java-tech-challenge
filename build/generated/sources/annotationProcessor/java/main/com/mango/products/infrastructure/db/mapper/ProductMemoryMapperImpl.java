package com.mango.products.infrastructure.db.mapper;

import com.mango.products.domain.Product;
import com.mango.products.infrastructure.db.entity.ProductMemoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-05T22:49:32+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ProductMemoryMapperImpl implements ProductMemoryMapper {

    @Autowired
    private PriceMemoryMapper priceMemoryMapper;

    @Override
    public ProductMemoryEntity toEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductMemoryEntity productMemoryEntity = new ProductMemoryEntity();

        productMemoryEntity.setId( product.getId() );
        productMemoryEntity.setName( product.getName() );
        productMemoryEntity.setDescription( product.getDescription() );
        productMemoryEntity.setPrice( priceMemoryMapper.toEntity( product.getPrice() ) );
        productMemoryEntity.setVersion( product.getVersion() );
        productMemoryEntity.setCreatedAt( product.getCreatedAt() );
        productMemoryEntity.setActive( product.getActive() );

        return productMemoryEntity;
    }

    @Override
    public Product toDomain(ProductMemoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( entity.getId() );
        product.setName( entity.getName() );
        product.setDescription( entity.getDescription() );
        product.setPrice( priceMemoryMapper.toDomain( entity.getPrice() ) );
        product.setVersion( entity.getVersion() );
        product.setCreatedAt( entity.getCreatedAt() );
        product.setActive( entity.getActive() );

        return product;
    }
}
