package pl.karol.onlineshop.category.controller;

import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karol.onlineshop.common.model.Category;
import pl.karol.onlineshop.category.dto.CategoryProductsDto;
import pl.karol.onlineshop.category.service.CategoryService;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{slug}/products")
    public CategoryProductsDto getCategoryWithProducts(
            @PathVariable @Length(max = 255) @Pattern(regexp = "[a-z0-9\\-]+") String slug,
            Pageable pageable
    ) {
        return categoryService.getCategoryWithProducts(slug, pageable);
    }
}
