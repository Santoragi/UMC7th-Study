package umc7.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.spring.apiPayload.code.status.ErrorStatus;
import umc7.spring.apiPayload.exception.handler.StoreHandler;
import umc7.spring.converter.ReviewConverter;
import umc7.spring.domain.Review;
import umc7.spring.domain.Store;
import umc7.spring.repository.ReviewRepository.ReviewRepository;
import umc7.spring.repository.StoreRepository.StoreRepository;
import umc7.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review createReview(ReviewRequestDTO.WriteDTO request, Long storeId) {
        Review newReview = ReviewConverter.toReview(request);
        Store store = storeRepository.findById(storeId).orElseThrow(()-> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        newReview.setStore(store);

        return reviewRepository.save(newReview);


    }
}
