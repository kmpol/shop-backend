package pl.karol.onlineshop.category.dto;

import org.springframework.data.domain.Page;
import pl.karol.onlineshop.common.model.Category;
import pl.karol.onlineshop.common.dto.ProductListDto;

public record CategoryProductsDto(Category category, Page<ProductListDto> products) {
}
