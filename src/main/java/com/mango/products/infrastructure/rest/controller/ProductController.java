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
    public ResponseEntity<Void> createProduct(@RequestBody @Valid ProductDto dto) {
        log.debug("Create a Product: {}", dto);
        createProductUseCase.create(productMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/prices")
    public ResponseEntity<Void> addPrice(@PathVariable UUID id, @RequestBody @Valid PriceDto dto) {
        addPriceUseCase.add(id, priceMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/prices")
    public ResponseEntity<PriceValueDto> getPrices(@PathVariable UUID id, @RequestParam(required = false) LocalDate date) {
        return ResponseEntity.ok(priceMapper.toPriceValueDto(findPriceFromProductUseCase.findPriceAtDate(id, date)));
    }
}
