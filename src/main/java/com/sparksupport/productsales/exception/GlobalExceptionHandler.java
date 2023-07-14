package com.sparksupport.productsales.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND,productNotFoundException.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
