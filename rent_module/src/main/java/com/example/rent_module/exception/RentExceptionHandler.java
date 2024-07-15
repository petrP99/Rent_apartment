package com.example.rent_module.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RentExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> catchException(UserException e) {
        return ResponseEntity.status(e.getExceptionCode()).body(e.getMessage());
    }
}
