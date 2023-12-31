package pl.karol.onlineshop.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karol.onlineshop.common.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
