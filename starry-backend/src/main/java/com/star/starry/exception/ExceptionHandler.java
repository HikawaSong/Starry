package com.star.starry.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler{

    /**
     * 设置通常的400业务异常，AppException
     * @param ex 异常
     * @return 抛给前端的返回值
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(AppException.class)
    public ResponseEntity<Map<String,Object>> handleAppException(AppException ex){
        Map<String, Object> result = new HashMap<>();

        result.put("code", ex.getCode());
        result.put("message", ex.getMessage());

        log.warn("Business Error -> code={} msg={}", ex.getCode(), ex.getMessage(), ex);

        return ResponseEntity.badRequest().body(result);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, Object> result = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            result.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        log.warn("Valid Error -> msg={}",  ex.getMessage(), ex);

        return ResponseEntity.badRequest().body(result);
    }

    /**
     * 设置其他的500未知异常
     * @param ex 异常
     * @return 抛给前端的返回值ff
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleOtherException(Exception ex){
        Map<String, Object> result = new HashMap<>();

        result.put("code", 500);
        result.put("message", "UNKNOWN ERROR");

        log.warn("Error -> msg={}", ex.getMessage(), ex);

        return ResponseEntity.internalServerError().body(result);

    }
}
