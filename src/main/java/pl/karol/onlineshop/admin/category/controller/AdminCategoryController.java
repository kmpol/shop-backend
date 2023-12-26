package pl.karol.onlineshop.admin.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.karol.onlineshop.admin.category.controller.dto.AdminCategoryDto;
import pl.karol.onlineshop.admin.category.controller.dto.AdminCategoryMapper;
import pl.karol.onlineshop.admin.category.model.AdminCategory;
import pl.karol.onlineshop.admin.category.service.AdminCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/categories")
@RequiredArgsConstructor
public class AdminCategoryController {

    public static final Long EMPTY_ID = null;
    private final AdminCategoryService adminCategoryService;

    @GetMapping
    public List<AdminCategory> getCategories() {
        return adminCategoryService.getCategories();
    }

    @GetMapping("/{id}")
    public AdminCategory getCategory(@PathVariable Long id) {
        return adminCategoryService.getCategory(id);
    }

    @PostMapping
    public AdminCategory createCategory(@RequestBody AdminCategoryDto adminCategoryDto) {
        return adminCategoryService.createCategory(AdminCategoryMapper.mapDtoToAdminCategory(adminCategoryDto, EMPTY_ID));
    }

    @PutMapping("/{id}")
    public AdminCategory updateCategory(@PathVariable Long id, @RequestBody AdminCategoryDto adminCategoryDto) {
        return adminCategoryService.updateCategory(AdminCategoryMapper.mapDtoToAdminCategory(adminCategoryDto, id));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        adminCategoryService.deleteCategory(id);
    }
}
