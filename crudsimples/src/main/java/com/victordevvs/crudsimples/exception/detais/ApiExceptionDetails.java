package com.victordevvs.crudsimples.exception.detais;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiExceptionDetails {

    private LocalDateTime timestamp;
    private int status;
    private String message;
}
