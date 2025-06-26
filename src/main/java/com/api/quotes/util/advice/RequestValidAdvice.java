package com.api.quotes.util.advice;

import com.api.quotes.util.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Order(2)
@RestControllerAdvice
public class RequestValidAdvice {

    /*
        Request 데이터 또는 속성에 대한 에러 관련 핸들링 클래스

        400 - 요청 값 Valid 체크
        400 - JSON 포맷, 키 타입 에러
        415 - Content-type 미스매치
        422 - 커스텀 에러
        400 - DB 무결성 에러
        413, 500 - 파일 업로드 에러
     */



    /**
     * 405 - 요청 방식 오류 : Ex) GetMapping에 Post로 요청시 발생
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest httpServletRequest) {

        log.error("[ERROR] [MAPPING METHOD MISS] {}", e.getClass().getName());
        log.error(e.getMessage());
        log.error("[ERROR]");

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(HttpStatus.METHOD_NOT_ALLOWED.toString())
                        .path(httpServletRequest.getRequestURI())
                        .error("요청 method 타입(GET, POST, DELETE, PUT, ... ) 을 확인해주세요.")
                        .info(List.of(e.getMessage()))
                        .build()
                , HttpStatus.METHOD_NOT_ALLOWED);

    }

    /**
     * 400 JSON 포맷, 키 타입 에러
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest httpServletRequest) {

        log.error("[ERROR] [JSON PARSE MISS] {}", e.getClass().getName());

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.toString())
                        .path(httpServletRequest.getRequestURI())
                        .error("JSON 포맷 또는 키의 타입을 확인 하세요.")
                        .info(List.of(e.getMessage()))
                        .build()
                , HttpStatus.BAD_REQUEST);

    }

    /**
     * 415 Content-type 미스매치
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e, HttpServletRequest httpServletRequest) {

        log.error("[ERROR] [UNSUPPORTED MEDIA TYPE] {}", e.getClass().getName());
        log.error("잘못된 Content-type 으로 요청 하셨습니다.");
        log.error("[ERROR]");

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString())
                        .path(httpServletRequest.getRequestURI())
                        .error("잘못된 Content-type 으로 요청 하셨습니다.")
                        .info(List.of(e.getMessage()))
                        .build()
                , HttpStatus.UNSUPPORTED_MEDIA_TYPE);

    }


}
