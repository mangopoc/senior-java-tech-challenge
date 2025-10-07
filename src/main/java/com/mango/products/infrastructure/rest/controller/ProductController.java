package com.mango.products.infrastructure.rest.controller;

import com.mango.products.application.usecase.AddPriceToProductUseCase;
import com.mango.products.application.usecase.CreateProductUseCase;
import com.mango.products.application.usecase.FindPriceFromProductUseCase;
import com.mango.products.infrastructure.rest.dto.PriceDto;
import com.mango.products.infrastructure.rest.dto.PriceValueDto;
import com.mango.products.infrastructure.rest.dto.ProductDto;
import com.mango.products.infrastructure.rest.mapper.PriceMapper;
import com.mango.products.infrastructure.rest.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private CreateProductUseCase createProductUseCase;
    @Autowired
    private AddPriceToProductUseCase addPriceUseCase;
    @Autowired
    private FindPriceFromProductUseCase findPriceFromProductUseCase;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private PriceMapper priceMapper;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toDto(createProductUseCase.create(productMapper.toDomain(dto))));
    }

    @PostMapping("/{id}/prices")
    public ResponseEntity<Void> addPrice(@PathVariable UUID id, @RequestBody @Valid PriceDto dto) {
        addPriceUseCase.addPriceToProduct(id, priceMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}/prices")
    public ResponseEntity<PriceValueDto> getPrices(@PathVariable UUID id, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.ok(priceMapper.toPriceValueDto(findPriceFromProductUseCase.findPriceAtDate(id, date)));
    }
}
