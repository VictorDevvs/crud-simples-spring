package com.victordevvs.crudsimples.exception;

public class ExistingEmailException extends RuntimeException {
    public ExistingEmailException(String message) {
        super(message);
    }
}
