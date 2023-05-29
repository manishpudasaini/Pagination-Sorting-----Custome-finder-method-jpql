package com.pagination.learn.exception;

import org.springframework.http.HttpStatus;

public record ProductException(String message,HttpStatus httpStatus) {
}
