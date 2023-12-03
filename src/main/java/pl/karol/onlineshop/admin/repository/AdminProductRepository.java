package pl.karol.onlineshop.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.karol.onlineshop.admin.model.AdminProduct;

public interface AdminProductRepository extends JpaRepository<AdminProduct, Long> {
}
