package pl.karol.onlineshop.admin.product.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import pl.karol.onlineshop.admin.product.model.AdminProductCurrency;

import java.math.BigDecimal;

public record AdminProductDto(
        @NotBlank
        @Length(min = 3, max = 255)
        String name,
        @NotNull
        Long categoryId,
        @NotBlank
        @Length(min = 3, max = 1023)
        String description,
        @NotBlank
        @Length(min = 3, max = 2047)
        String fullDescription,

        @Min(0)
        BigDecimal price,
        AdminProductCurrency currency,
        String image,
        @NotBlank
        @Length(min = 3, max = 255)
        String slug) {
}
