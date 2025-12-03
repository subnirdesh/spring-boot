package com.nirdesh.coursemanager.exception;

import com.nirdesh.coursemanager.dto.reponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle Not Found errors
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(ResourceNotFoundException ex){
         ApiResponse<Object> response=ApiResponse.error(
                    ex.getHttpStatus().value(),
                  ex.getMessage());



        return ResponseEntity.status(ex.getHttpStatus()).body(response);

        }



    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequest(BadRequestException ex){
            ApiResponse<Object> response=ApiResponse.error(
                    HttpStatus.NOT_FOUND.value(),
                    ex.getMessage()
            );

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }







    }

