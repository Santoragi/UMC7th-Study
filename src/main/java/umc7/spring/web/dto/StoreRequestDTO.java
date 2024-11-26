package umc7.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc7.spring.validation.annotation.ExistRegions;

public class StoreRequestDTO {

    @Getter
    public static class CreateDTO{
        @NotBlank
        String name;

        @NotBlank
        String address;

        @ExistRegions
        Long region;
    }
}
