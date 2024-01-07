package pl.karol.onlineshop.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.karol.onlineshop.common.dto.ProductDto;
import pl.karol.onlineshop.common.dto.ReviewDto;
import pl.karol.onlineshop.common.model.Product;
import pl.karol.onlineshop.common.model.Review;
import pl.karol.onlineshop.common.repository.ProductRepository;
import pl.karol.onlineshop.common.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public ProductDto getProductBySlug(String slug) {
        Product product = productRepository.findBySlug(slug).orElseThrow();
        List<Review> moderatedReviews = reviewRepository.findAllByProductIdAndIsModerated(product.getId(), true);
        return mapToProductWithReviews(product, moderatedReviews);
    }

    private static ProductDto mapToProductWithReviews(Product product, List<Review> moderatedReviews) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .image(product.getImage())
                .slug(product.getSlug())
                .categoryId(product.getCategoryId())
                .description(product.getDescription())
                .fullDescription(product.getFullDescription())
                .currency(product.getCurrency())
                .reviews(moderatedReviews.stream().map(review -> ReviewDto.builder()
                                .id(review.getId())
                                .productId(review.getProductId())
                                .authorName(review.getAuthorName())
                                .content(review.getContent())
                                .isModerated(review.getIsModerated())
                                .build())
                        .toList())
                .build();
    }
}
