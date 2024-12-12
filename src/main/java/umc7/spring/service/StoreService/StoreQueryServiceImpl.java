package umc7.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7.spring.domain.Mission;
import umc7.spring.domain.Review;
import umc7.spring.domain.Store;
import umc7.spring.repository.MissionRepository.MissionRepository;
import umc7.spring.repository.ReviewRepository.ReviewRepository;
import umc7.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page){

        Store store = storeRepository.findById(storeId).get();

        Page<Review> storePage= reviewRepository.findAllByStore(store, PageRequest.of(page,10));

        // storePage 내용 출력
        System.out.println("Total Elements: " + storePage.getTotalElements()); // 전체 요소 수
        System.out.println("Total Pages: " + storePage.getTotalPages());       // 전체 페이지 수
        System.out.println("Current Page: " + storePage.getNumber());          // 현재 페이지 번호
        System.out.println("Page Size: " + storePage.getSize());               // 페이지 크기

        // 각 Review의 내용 출력
        storePage.getContent().forEach(review -> {
            System.out.println("Review ID: " + review.getId());
            System.out.println("Title: " + review.getTitle());
            System.out.println("Body: " + review.getBody());
            System.out.println("Stars: " + review.getStars());
            System.out.println("Reply: " + review.getReply());
        });

        return storePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> missionPage = missionRepository.findAllByStore(store, PageRequest.of(page,10));

        return missionPage;
    }

}