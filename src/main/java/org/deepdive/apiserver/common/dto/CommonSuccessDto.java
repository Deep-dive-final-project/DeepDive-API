package org.deepdive.apiserver.common.dto;

import lombok.Builder;

@Builder
public record CommonSuccessDto(boolean isSuccess) {
    public static CommonSuccessDto fromEntity(boolean isSuccess) {
        return CommonSuccessDto.builder()
                .isSuccess(isSuccess)
                .build();
    }
}
