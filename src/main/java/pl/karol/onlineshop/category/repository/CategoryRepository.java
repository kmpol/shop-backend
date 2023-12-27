package pl.karol.onlineshop.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karol.onlineshop.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
