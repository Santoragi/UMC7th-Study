package umc7.spring.service.ReviewService;

import umc7.spring.domain.Review;
import umc7.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review createReview(ReviewRequestDTO.WriteDTO request, Long storeId);
}
