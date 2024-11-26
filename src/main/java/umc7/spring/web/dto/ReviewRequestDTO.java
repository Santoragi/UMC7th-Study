package umc7.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class WriteDTO{
        @NotBlank
        String title;
        @NotBlank
        String body;
        @NotNull
        Float stars;
    }
}
