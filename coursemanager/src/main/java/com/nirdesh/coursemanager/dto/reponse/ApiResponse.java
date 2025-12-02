package com.nirdesh.coursemanager.dto.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean success;
    private int status;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    // For success
    public static <T> ApiResponse<T> success(int status,String message, T data){
        return new ApiResponse<>(true,status,message,data,LocalDateTime.now());
    }


    //For error
    public static <T> ApiResponse<T> error(int status,String message){
        return new ApiResponse<>(false,status,message,null,LocalDateTime.now());
    }




}
