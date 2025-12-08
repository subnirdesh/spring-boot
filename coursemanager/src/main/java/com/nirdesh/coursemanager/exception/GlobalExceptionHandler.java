package com.nirdesh.coursemanager.exception;

import com.nirdesh.coursemanager.dto.reponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle Not Found errors
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Object>> handleApiException(ApiException ex){
         ApiResponse<Object> response=ApiResponse.error(
                    ex.getHttpStatus().value(),
                  ex.getMessage());

        return ResponseEntity.status(ex.getHttpStatus()).body(response);

        }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleOtherException(Exception ex){
        ApiResponse<Object> response=ApiResponse.error(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

    }














    }

