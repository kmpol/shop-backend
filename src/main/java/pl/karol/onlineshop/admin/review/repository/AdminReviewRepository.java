package pl.karol.onlineshop.admin.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.karol.onlineshop.admin.review.model.AdminReview;

@Repository
public interface AdminReviewRepository extends JpaRepository<AdminReview, Long> {

    @Query("update AdminReview r set r.isModerated=true where r.id=:id")
    @Modifying
    void moderate(Long id);
}
