package umc7.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc7.spring.apiPayload.ApiResponse;
import umc7.spring.converter.ReviewConverter;
import umc7.spring.domain.Review;
import umc7.spring.service.ReviewService.ReviewCommandService;
import umc7.spring.validation.annotation.ExistStores;
import umc7.spring.web.dto.ReviewRequestDTO;
import umc7.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> create(@RequestParam(name="storeId") @ExistStores Long storeId, @RequestBody @Valid ReviewRequestDTO.WriteDTO request){
        Review review = reviewCommandService.createReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(review));
    }
}
