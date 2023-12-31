package pl.karol.onlineshop.review.controller.dto;

import pl.karol.onlineshop.common.model.Review;
import pl.karol.onlineshop.utils.JsoupUtilFunction;

public class ReviewDtoMapper {

    public static Review mapDtoToReview(ReviewDto dto) {
        JsoupUtilFunction jsoupUtilFunction = new JsoupUtilFunction();
        return Review.builder()
                .authorName(jsoupUtilFunction.apply(dto.authorName()))
                .content(jsoupUtilFunction.apply(dto.content()))
                .productId(dto.productId())
                .build();
    }
}
