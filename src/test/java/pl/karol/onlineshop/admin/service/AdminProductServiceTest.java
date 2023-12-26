package pl.karol.onlineshop.admin.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.karol.onlineshop.admin.model.AdminProduct;
import pl.karol.onlineshop.admin.model.AdminProductCurrency;
import pl.karol.onlineshop.admin.repository.AdminProductRepository;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AdminProductServiceTest {

    @Mock
    private AdminProductRepository adminProductRepository;

    @InjectMocks
    private AdminProductService adminProductService;

    @Test
    public void givenNonExistingProductIdWhenGetProductByIdThenThrowError() {
        given(adminProductRepository.findById(2L)).willReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            adminProductService.getProduct(2L);
        });
    }

    @Test
    public void givenExistingProductIdWhenGetProductByIdThenAdminProductIsTruthy() {
        AdminProduct adminProduct = AdminProduct.builder()
                .id(1L)
                .name("some name")
                .description("some desc")
                .slug("slug")
                .fullDescription("full desc")
                .price(new BigDecimal(10))
                .image("asd/asd")
                .category("cat 1")
                .currency(AdminProductCurrency.PLN)
                .build();
        given(adminProductRepository.findById(1L)).willReturn(Optional.of(adminProduct));

        AdminProduct productResponse = adminProductService.getProduct(1L);

        assertThat(productResponse).isNotNull();
        assertThat(productResponse.getId()).isEqualTo(1L);
    }
}