package com.pagination.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundexception.class)
    public ResponseEntity<Object> exceptionHandler(ProductNotFoundexception productNotFoundexception){
        ProductException productException = new ProductException(productNotFoundexception.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productException, HttpStatus.NOT_FOUND);
    }

}
