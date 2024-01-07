package pl.karol.onlineshop.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.karol.onlineshop.common.model.Review;
import pl.karol.onlineshop.common.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        // All new reviews must be false by default
        review.setIsModerated(false);
        return reviewRepository.save(review);
    }
}
