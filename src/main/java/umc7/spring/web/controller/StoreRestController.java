package umc7.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc7.spring.apiPayload.ApiResponse;
import umc7.spring.converter.StoreConverter;
import umc7.spring.domain.Store;
import umc7.spring.service.StoreService.StoreCommandService;
import umc7.spring.web.dto.StoreRequestDTO;
import umc7.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateResultDTO> create(@RequestBody @Valid StoreRequestDTO.CreateDTO request){
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultDTO(store));
    }
}
