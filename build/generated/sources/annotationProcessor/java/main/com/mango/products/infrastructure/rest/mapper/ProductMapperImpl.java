package com.mango.products.infrastructure.rest.mapper;

import com.mango.products.domain.Product;
import com.mango.products.infrastructure.rest.dto.ProductDto;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-07T21:31:52+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( priceMapper.toDto( product.getPrice() ) );
        productDto.setVersion( product.getVersion() );
        productDto.setCreatedAt( product.getCreatedAt() );
        productDto.setActive( product.getActive() );

        return productDto;
    }

    @Override
    public Product toDomain(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setName( dto.getName() );
        product.setDescription( dto.getDescription() );
        product.setPrice( priceMapper.toDomain( dto.getPrice() ) );
        product.setVersion( dto.getVersion() );
        product.setCreatedAt( dto.getCreatedAt() );
        product.setActive( dto.getActive() );

        return product;
    }
}
