package umc7.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc7.spring.domain.Mission;
import umc7.spring.domain.Review;
import umc7.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    Page<Review> getReviewList(Long storeId, Integer page);
    Page<Mission> getMissionList(Long storeId, Integer page);
}
