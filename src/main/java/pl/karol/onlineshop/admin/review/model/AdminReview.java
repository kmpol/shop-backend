package pl.karol.onlineshop.admin.review.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "review")
@Getter
public class AdminReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String authorName;
    private String content;
    @Column(name = "is_moderated")
    private Boolean isModerated;
}
