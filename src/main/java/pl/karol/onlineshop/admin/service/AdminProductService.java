package pl.karol.onlineshop.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.karol.onlineshop.admin.controller.dto.AdminProductDto;
import pl.karol.onlineshop.admin.controller.dto.AdminProductMapper;
import pl.karol.onlineshop.admin.model.AdminProduct;
import pl.karol.onlineshop.admin.repository.AdminProductRepository;


@Service
public class AdminProductService {

    public static final Long EMPTY_ID = null;

    private final AdminProductRepository adminProductRepository;

    public AdminProductService(AdminProductRepository adminProductRepository) {
        this.adminProductRepository = adminProductRepository;
    }

    public Page<AdminProduct> getProducts(Pageable pageable) {
        return adminProductRepository.findAll(pageable);
    }

    public AdminProduct getProduct(Long id) {
        return adminProductRepository.findById(id).orElseThrow();
    }

    public AdminProduct createProduct(AdminProductDto adminProductDto) {
        AdminProduct product = AdminProductMapper.mapDtoToAdminProduct(adminProductDto, EMPTY_ID);
        return adminProductRepository.save(product);
    }

    public AdminProduct updateProduct(AdminProductDto updatedProductDto, Long productId) {
        AdminProduct product = AdminProductMapper.mapDtoToAdminProduct(updatedProductDto, productId);
        return adminProductRepository.save(product);
    }

    public void deleteProduct(Long id) {
        adminProductRepository.deleteById(id);
    }
}
