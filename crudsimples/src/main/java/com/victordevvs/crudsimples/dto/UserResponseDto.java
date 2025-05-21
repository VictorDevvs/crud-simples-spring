package com.victordevvs.crudsimples.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
}
