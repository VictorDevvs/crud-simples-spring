package com.victordevvs.crudsimples.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;
import static jakarta.persistence.GenerationType.*;

@Data
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDate birthDate;
    private String password;

}
