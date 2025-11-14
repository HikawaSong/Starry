package com.star.starry.model.account;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@Setter
public class SignupForm {

    @NotBlank(message = "{username.notBlank}")
    @Size(min = 2, max = 10, message = "{username.size}")
    private String name;

    @NotBlank(message = "{password.notBlank}")
    @Size(min = 6, max = 20, message = "{password.size}")
    private String password;

    @NotBlank(message = "{email.notBlank}")
    @Email(message = "{email.format}")
    private String email;

    private String birthday;

    private String gender;

}
