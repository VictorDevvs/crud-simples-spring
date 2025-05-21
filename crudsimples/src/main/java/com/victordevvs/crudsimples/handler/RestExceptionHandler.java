package com.victordevvs.crudsimples.handler;

import com.victordevvs.crudsimples.exception.UserNotFoundException;
import com.victordevvs.crudsimples.exception.detais.ApiExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiExceptionDetails> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ApiExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
