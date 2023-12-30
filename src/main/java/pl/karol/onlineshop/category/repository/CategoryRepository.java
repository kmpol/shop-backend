package pl.karol.onlineshop.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.karol.onlineshop.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    @Query("SELECT c from Category c left join fetch c.products where c.slug =:slug")
    Category findBySlug(String slug);

}
