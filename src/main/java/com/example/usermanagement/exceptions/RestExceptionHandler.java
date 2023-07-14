package com.example.usermanagement.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {DuplicateEntityException.class})
    protected ExceptionResponse errorHandlerDuplication(DuplicateEntityException exception, WebRequest request) {
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setErrorCode("409");
        error.setTimestamp(new Date());
        return error;
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ExceptionResponse errorHandlerNotFound(EntityNotFoundException exception, WebRequest request) {
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setErrorCode("404");
        error.setTimestamp(new Date());
        return error;
    }
}
