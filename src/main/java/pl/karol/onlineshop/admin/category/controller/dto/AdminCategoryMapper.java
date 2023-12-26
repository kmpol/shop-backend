package pl.karol.onlineshop.admin.category.controller.dto;

import pl.karol.onlineshop.admin.category.model.AdminCategory;
import pl.karol.onlineshop.utils.SlugifyUtilFunction;

public class AdminCategoryMapper {

    public static AdminCategory mapDtoToAdminCategory(AdminCategoryDto dto, Long id) {
        return AdminCategory.builder()
                .id(id)
                .name(dto.getName())
                .description(dto.getDescription())
                .slug(new SlugifyUtilFunction().apply(dto.getSlug()))
                .build();
    }
}
