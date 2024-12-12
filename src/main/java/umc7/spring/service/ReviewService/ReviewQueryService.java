package umc7.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc7.spring.domain.Review;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long memberId, Integer page);
}
