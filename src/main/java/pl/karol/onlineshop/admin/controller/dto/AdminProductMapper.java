package pl.karol.onlineshop.admin.controller.dto;

import pl.karol.onlineshop.admin.model.AdminProduct;

public class AdminProductMapper {
    public static AdminProduct mapDtoToAdminProduct(AdminProductDto dto, Long productId) {
        return AdminProduct.builder()
                .id(productId)
                .name(dto.name())
                .price(dto.price())
                .currency(dto.currency())
                .category(dto.category())
                .description(dto.description())
                .image(dto.image())
                .build();
    }
}
