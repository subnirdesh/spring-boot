package com.nirdesh.coursemanager.exception;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.http.HttpStatus;

public class DatabaseException extends BaseException {
    public DatabaseException(String message){
        super(message, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
