package org.deepdive.apiserver.dto.global;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;
import org.deepdive.apiserver.exception.ErrorCode;

@Getter
@Schema(name = "ExceptionDto", description = "API 예외 발생 시 응답 DTO")
public class ExceptionDto {
    @Schema(name = "code", description = "에러 코드")
    @NotNull
    private final Integer code;

    @Schema(name = "message", description = "에러 메시지")
    @NotNull
    private final String message;

    public ExceptionDto(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public static ExceptionDto of(ErrorCode errorCode) {
        return new ExceptionDto(errorCode);
    }
}
