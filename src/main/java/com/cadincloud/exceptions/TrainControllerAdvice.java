package com.cadincloud.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class TrainControllerAdvice {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler
    ApiError handleResourceNotFoundException(ResourceNotFoundException rnfe) {
        return new ApiError(1001, rnfe.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler
    ApiError handleValidationException(ValidationException ve) {
        return new ApiError(1002, ve.getMessage());
    }
}

record ApiError(int code, String message) {
}
