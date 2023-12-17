package pl.karol.onlineshop.product.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.karol.onlineshop.product.model.Product;
import pl.karol.onlineshop.product.repository.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    //TODO: Test needs to be removed, testing only mocks, useless test
    @Test
    void shouldGetNProducts() {
        //Given
        List<Product> products = List.of(
                Mockito.mock(Product.class),
                Mockito.mock(Product.class),
                Mockito.mock(Product.class),
                Mockito.mock(Product.class),
                Mockito.mock(Product.class),
                Mockito.mock(Product.class),
                Mockito.mock(Product.class),
                Mockito.mock(Product.class)
        );

        int pageSize = products.size();
        Pageable pageable = PageRequest.of(0, pageSize);
        Page<Product> productPage = new PageImpl<>(products);

        when(productRepository.findAll(pageable)).thenReturn(productPage);

        //When
        Page<Product> productsResponse = productService.getProducts(pageable);
        long totalElements = productsResponse.getTotalElements();

        //Then
        assertEquals(totalElements, pageSize);
    }

}
