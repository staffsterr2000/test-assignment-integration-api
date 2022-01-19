package com.staffsterr2000.integrationapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class IntegrationApiExceptionHandler {

    @ExceptionHandler(UnsuccessfulOperationException.class)
    protected ResponseEntity<String> handleUnsuccessfulOperationException(UnsuccessfulOperationException ex) {
        log.info("Response: " + ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
