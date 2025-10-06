package com.mango.products.infrastructure.rest.validation;

import com.mango.products.infrastructure.rest.dto.PriceDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, PriceDto> {

    @Override
    public boolean isValid(PriceDto dto, ConstraintValidatorContext context) {
        if (dto.getInitDate() == null || dto.getEndDate() == null) {
            return true; // o false si quieres que sean obligatorias
        }
        return dto.getInitDate().isBefore(dto.getEndDate());
    }
}
