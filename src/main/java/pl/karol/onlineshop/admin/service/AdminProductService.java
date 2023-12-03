package pl.karol.onlineshop.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.karol.onlineshop.admin.model.AdminProduct;
import pl.karol.onlineshop.admin.repository.AdminProductRepository;

@Service
public class AdminProductService {

    private final AdminProductRepository adminProductRepository;

    public AdminProductService(AdminProductRepository adminProductRepository) {
        this.adminProductRepository = adminProductRepository;
    }

    public Page<AdminProduct> getProducts(Pageable pageable) {
        return adminProductRepository.findAll(pageable);
    }
}
