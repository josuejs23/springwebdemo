package com.josuejs.springwebdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){

        StudentErrorResponse errorMessage = new StudentErrorResponse();
        errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){

        StudentErrorResponse errorMessage = new StudentErrorResponse();
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
