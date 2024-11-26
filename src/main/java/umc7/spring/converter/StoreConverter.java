package umc7.spring.converter;

import umc7.spring.domain.Store;
import umc7.spring.web.dto.StoreRequestDTO;
import umc7.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.CreateResultDTO toCreateResultDTO(Store store){
        return StoreResponseDTO.CreateResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateDTO request){

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
