package pl.karol.onlineshop.product.controller;

import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karol.onlineshop.common.dto.ProductDto;
import pl.karol.onlineshop.common.dto.ProductListDto;
import pl.karol.onlineshop.common.model.Product;
import pl.karol.onlineshop.product.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductListDto> getProducts(Pageable pageable) {
        Page<Product> products = productService.getProducts(pageable);
        List<ProductListDto> productListDtos = products.getContent().stream()
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
        return new PageImpl<>(productListDtos, pageable, products.getTotalElements());

    }

    @GetMapping(path = "{slug}")
    public ProductDto getProductBySlug(
            @PathVariable
            @Pattern(regexp = "[a-z0-9\\-]+")
            @Length(max = 255) String slug) {
        return productService.getProductBySlug(slug);
    }

}
