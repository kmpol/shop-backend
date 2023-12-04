package pl.karol.onlineshop.admin.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.karol.onlineshop.admin.controller.dto.AdminProductDto;
import pl.karol.onlineshop.admin.model.AdminProduct;
import pl.karol.onlineshop.admin.service.AdminProductService;

@RestController
@RequestMapping("/api/v1/admin/products")
public class AdminProductController {

    private final AdminProductService adminProductService;

    public AdminProductController(AdminProductService adminProductService) {
        this.adminProductService = adminProductService;
    }

    @GetMapping
    public Page<AdminProduct> getProducts(Pageable pageable) {
        return adminProductService.getProducts(pageable);
    }

    @GetMapping(path = "{productId}")
    public AdminProduct getProduct(@PathVariable Long productId) {
        return adminProductService.getProduct(productId);
    }

    @PostMapping
    public AdminProduct saveProduct(@RequestBody AdminProductDto adminProductDto) {
        return adminProductService.createProduct(adminProductDto);
    }

    @PutMapping(path = "{productId}")
    public AdminProduct updateProduct(@RequestBody AdminProductDto updates, @PathVariable Long productId) {
        return adminProductService.updateProduct(updates, productId);
    }
}
