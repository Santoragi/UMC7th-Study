package umc7.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.spring.apiPayload.code.status.ErrorStatus;
import umc7.spring.apiPayload.exception.handler.RegionHandler;
import umc7.spring.converter.StoreConverter;
import umc7.spring.domain.Region;
import umc7.spring.domain.Store;
import umc7.spring.repository.RegionRepository.RegionRepository;
import umc7.spring.repository.StoreRepository.StoreRepository;
import umc7.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store createStore(StoreRequestDTO.CreateDTO request){
        Store newStore = StoreConverter.toStore(request);
        Region region = regionRepository.findById(request.getRegion()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        newStore.setRegion(region);

        return storeRepository.save(newStore);

    }
}
