package pl.karol.onlineshop.admin.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.karol.onlineshop.admin.product.model.AdminProduct;

public interface AdminProductRepository extends JpaRepository<AdminProduct, Long> {
}
