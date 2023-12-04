package pl.karol.onlineshop.admin.controller.dto;

import java.math.BigDecimal;

public record AdminProductDto(String name, String category, String description, BigDecimal price, String currency) {
}
