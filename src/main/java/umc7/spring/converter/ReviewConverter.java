package umc7.spring.converter;

import umc7.spring.domain.Review;
import umc7.spring.web.dto.ReviewRequestDTO;
import umc7.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review){
        return ReviewResponseDTO.CreateResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.WriteDTO request){
        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .stars(request.getStars())
                .build();
    }
}
