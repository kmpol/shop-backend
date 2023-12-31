package pl.karol.onlineshop.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.karol.onlineshop.category.model.Category;
import pl.karol.onlineshop.category.model.CategoryProductsDto;
import pl.karol.onlineshop.category.repository.CategoryRepository;
import pl.karol.onlineshop.product.controller.dto.ProductListDto;
import pl.karol.onlineshop.product.model.Product;
import pl.karol.onlineshop.product.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CategoryProductsDto getCategoryWithProducts(String slug, Pageable pageable) {
        Category category = categoryRepository.findBySlug(slug);
        Page<Product> page = productRepository.findByCategoryId(category.getId(), pageable);
        List<ProductListDto> productListDtos = page.getContent().stream()
                .map(product -> ProductListDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .currency(product.getCurrency())
                        .slug(product.getSlug())
                        .image(product.getImage())
                        .build())
                .toList();
        return new CategoryProductsDto(category, new PageImpl<>(productListDtos, pageable, page.getTotalElements()));
    }
}
