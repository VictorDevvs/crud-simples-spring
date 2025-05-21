package com.victordevvs.crudsimples.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
public class UserRequestDto {
        private Long id;

        @NotNull(message = "name is mandatory")
        @NotEmpty(message = "name is mandatory")
        @Size(min = 3, max = 100, message = "name must have between 3 and 100 characters")
        private String name;

        @NotNull(message = "email is mandatory")
        @NotEmpty(message = "email is mandatory")
        @Email
        @Column(unique = true)
        private String email;

        @NotNull(message = "birth Date is mandatory")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate birthDate;

        @NotNull(message = "password is mandatory")
        @NotEmpty(message = "password is mandatory")
        @Size(min = 6, message = "password must have at least 6 characters")
        private String password;
}
