package pl.karol.onlineshop.admin.product.controller.dto;

import pl.karol.onlineshop.admin.product.model.AdminProduct;
import pl.karol.onlineshop.utils.SlugifyUtilFunction;

public class AdminProductMapper {
    public static AdminProduct mapDtoToAdminProduct(AdminProductDto dto, Long productId) {
        return AdminProduct.builder()
                .id(productId)
                .name(dto.name())
                .price(dto.price())
                .currency(dto.currency())
                .category(dto.category())
                .description(dto.description())
                .fullDescription(dto.fullDescription())
                .image(dto.image())
                .slug(new SlugifyUtilFunction().apply(dto.slug()))
                .build();
    }
}
