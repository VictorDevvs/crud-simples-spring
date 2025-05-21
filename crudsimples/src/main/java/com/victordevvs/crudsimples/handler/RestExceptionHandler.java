package com.victordevvs.crudsimples.handler;

import com.victordevvs.crudsimples.exception.ExistingEmailException;
import com.victordevvs.crudsimples.exception.UserNotFoundException;
import com.victordevvs.crudsimples.exception.detais.ApiExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionDetails> handleInvalidFieldException(MethodArgumentNotValidException ex){
        String errors =  ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return new ResponseEntity<>(ApiExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(errors)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiExceptionDetails> handleInvalidFieldException(NoResourceFoundException ex){
        return new ResponseEntity<>(ApiExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("ID is null or empty")
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingEmailException.class)
    public ResponseEntity<ApiExceptionDetails> handleExistingEmailException(ExistingEmailException ex){
        return new ResponseEntity<>(ApiExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
