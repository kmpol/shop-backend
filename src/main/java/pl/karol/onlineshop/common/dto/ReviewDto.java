package pl.karol.onlineshop.common.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewDto {
    private Long id;
    private Long productId;
    private String authorName;
    private String content;
    private boolean isModerated;
}
