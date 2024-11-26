package umc7.spring.service.StoreService;

import umc7.spring.domain.Store;
import umc7.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store createStore(StoreRequestDTO.CreateDTO request);
}
