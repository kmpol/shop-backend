package pl.karol.onlineshop.admin.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.karol.onlineshop.admin.review.model.AdminReview;
import pl.karol.onlineshop.admin.review.service.AdminReviewService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/reviews")
public class AdminReviewController {

    private final AdminReviewService adminReviewService;

    @GetMapping
    public List<AdminReview> getReviews() {
        return adminReviewService.getReviews();
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        adminReviewService.delete(id);
    }

    @PatchMapping("/{id}/moderate")
    public void moderate(@PathVariable Long id) {
        adminReviewService.moderate(id);
    }

}
