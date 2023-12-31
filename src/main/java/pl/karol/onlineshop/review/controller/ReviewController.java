package pl.karol.onlineshop.review.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karol.onlineshop.review.controller.dto.ReviewDto;
import pl.karol.onlineshop.review.controller.dto.ReviewDtoMapper;
import pl.karol.onlineshop.common.model.Review;
import pl.karol.onlineshop.review.service.ReviewService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public Review addReview(@RequestBody @Valid ReviewDto reviewDto) {
        return reviewService.addReview(ReviewDtoMapper.mapDtoToReview(reviewDto));
    }
}
