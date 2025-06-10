package com.star.starry.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Account {

    private String name;

    private String password;

    private String email;

    private LocalDate birthday;

    private Gender gender;
}
