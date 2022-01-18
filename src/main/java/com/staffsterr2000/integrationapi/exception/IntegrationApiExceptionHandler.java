package com.staffsterr2000.integrationapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IntegrationApiExceptionHandler {

    @ExceptionHandler(UnsuccessfulOperationException.class)
    protected ResponseEntity<String> handleUnsuccessfulOperationException(UnsuccessfulOperationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
