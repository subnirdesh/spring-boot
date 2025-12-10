package com.nirdesh.coursemanager.dto.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean success;
    private Integer status;
    private String message;
    private T data;
    private Object errors;
    private LocalDateTime timestamp;


    // For success with data
    public static <T> ApiResponse<T> success(int status,String message, T data){
        return new ApiResponse<>(true,status,message,data,null,LocalDateTime.now());
    }

    // For success without data
    public static <T> ApiResponse<T> success(int status,String message){
        return new ApiResponse<>(true,status,message,null,null,LocalDateTime.now());
    }

    //For success only with message
    public static <T> ApiResponse<T> success(String message){
        return new ApiResponse<>(true,null,message,null,null,LocalDateTime.now());
    }



    //For error
    public static <T> ApiResponse<T> error(int status,String message){
        return new ApiResponse<>(false,status,message,null,null,LocalDateTime.now());
    }

    public static <T> ApiResponse<T> error(int status,String message, Object errors){
        return new ApiResponse<>(false,status,message,null,errors,LocalDateTime.now());
    }






}
