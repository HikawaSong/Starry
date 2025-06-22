package com.star.starry.model.dto;

import com.star.starry.model.common.BaseDto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Account extends BaseDto {

    private String name;

    private String password;

    private String email;

    private LocalDate birthday;

    private Gender gender;
}
