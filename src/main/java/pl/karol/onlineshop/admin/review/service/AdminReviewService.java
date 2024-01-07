package pl.karol.onlineshop.admin.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.karol.onlineshop.admin.review.model.AdminReview;
import pl.karol.onlineshop.admin.review.repository.AdminReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminReviewService {

    private final AdminReviewRepository adminReviewRepository;

    public List<AdminReview> getReviews() {
        return adminReviewRepository.findAll();
    }

    public void delete(Long id) {
        adminReviewRepository.deleteById(id);
    }

    @Transactional
    public void moderate(Long id) {
        adminReviewRepository.moderate(id);
    }
}
