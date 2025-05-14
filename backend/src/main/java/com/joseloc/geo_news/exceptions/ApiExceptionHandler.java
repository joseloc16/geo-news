package com.joseloc.geo_news.exceptions;

import com.joseloc.geo_news.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<ApiResponse<Object>> handleApiRequestException(ApiRequestException ex) {
        ApiResponse<Object> response = ApiResponse.error(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(Exception ex) {
        ApiResponse<Object> response = ApiResponse.error("An unexpected error occurred: "+ ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
