package org.deepdive.apiserver.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Method Not Allowed Error
    METHOD_NOT_ALLOWED(40500, HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 HTTP 메소드입니다."),

    // Not Found Error
    NOT_FOUND_END_POINT(40400, HttpStatus.NOT_FOUND, "존재하지 않는 API 엔드포인트입니다."),
    NOT_FOUND_RESOURCE(40400, HttpStatus.NOT_FOUND, "해당 리소스가 존재하지 않습니다."),
    NOT_FOUND_LOGIN_USER(40401, HttpStatus.NOT_FOUND, "로그인한 사용자가 존재하지 않습니다."),
    NOT_FOUND_AUTHORIZATION_HEADER(40401, HttpStatus.NOT_FOUND, "Authorization 헤더가 존재하지 않습니다."),
    NOT_FOUND_MEMBER(40402, HttpStatus.NOT_FOUND, "해당 사용자가 존재하지 않습니다."),
    NOT_FOUND_SHARED_URL(40403, HttpStatus.NOT_FOUND, "해당 공유 URL이 존재하지 않습니다."),
    NOT_FOUND_MEMO(40404, HttpStatus.NOT_FOUND, "해당하는 메모가 존재하지 않습니다"),

    // Invalid Argument Error
    MISSING_REQUEST_PARAMETER(40000, HttpStatus.BAD_REQUEST, "필수 요청 파라미터가 누락되었습니다."),
    INVALID_ARGUMENT(40001, HttpStatus.BAD_REQUEST, "요청에 유효하지 않은 인자입니다."),
    INVALID_PARAMETER_FORMAT(40002, HttpStatus.BAD_REQUEST, "요청에 유효하지 않은 인자 형식입니다."),
    INVALID_HEADER_ERROR(40003, HttpStatus.BAD_REQUEST, "유효하지 않은 헤더입니다."),
    MISSING_REQUEST_HEADER(40004, HttpStatus.BAD_REQUEST, "필수 요청 헤더가 누락되었습니다."),
    BAD_REQUEST_PARAMETER(40005, HttpStatus.BAD_REQUEST, "잘못된 요청 파라미터입니다."),
    BAD_REQUEST_JSON(40006, HttpStatus.BAD_REQUEST, "잘못된 JSON 형식입니다."),
    SEARCH_SHORT_LENGTH_ERROR(40007, HttpStatus.BAD_REQUEST, "검색어는 2글자 이상이어야 합니다."),
    INVALID_FUNDING_STATUS(40009, HttpStatus.BAD_REQUEST, "펀딩이 정상적이지 않습니다."),

    // Gone Error
    GONE_SHARED_URL(41001, HttpStatus.GONE, "해당 공유 URL이 만료되었습니다."),

    // Access Denied Error
    ACCESS_DENIED(40300, HttpStatus.FORBIDDEN, "접근 권한이 없습니다."),
    NOT_MATCH_AUTH_CODE(40301, HttpStatus.FORBIDDEN, "인증 코드가 일치하지 않습니다."),
    NOT_MATCH_USER(40302, HttpStatus.FORBIDDEN, "해당 사용자가 일치하지 않습니다."),


    INTERNAL_SERVER_ERROR(50000, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 에러입니다."),
    UPLOAD_FILE_ERROR(50001, HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패하였습니다."),
    INTERNAL_SAVE_ERROR(50003, HttpStatus.INTERNAL_SERVER_ERROR, "기프트에 아이템 담기 실패"),

    ALREADY_EXIST_MEMBER(50002, HttpStatus.INTERNAL_SERVER_ERROR, "사용자가 이미 존재합니다.");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
