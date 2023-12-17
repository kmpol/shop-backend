package pl.karol.onlineshop.admin.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import pl.karol.onlineshop.admin.model.AdminProductCurrency;

import java.math.BigDecimal;

public record AdminProductDto(
        @NotBlank
        @Length(min = 3, max = 255)
        String name,
        @NotBlank
        @Length(min = 3, max = 255)
        String category,
        @NotBlank
        @Length(min = 3, max = 1023)
        String description,
        @Min(0)
        BigDecimal price,
        AdminProductCurrency currency) {
}
