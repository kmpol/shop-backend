package pl.karol.onlineshop.category.model;

import org.springframework.data.domain.Page;
import pl.karol.onlineshop.product.controller.dto.ProductListDto;
import pl.karol.onlineshop.product.model.Product;

public record CategoryProductsDto(Category category, Page<ProductListDto> products) {
}
