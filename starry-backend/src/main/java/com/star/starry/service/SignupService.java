package com.star.starry.service;

import com.star.starry.model.dto.Account;
import com.star.starry.model.form.SignupForm;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SignupService {
    public void signup(SignupForm form) {
        var account = Account.builder()
                .name(form.getName())
                .email(form.getEmail())
                .password(form.getPassword())
                .build();

    }
}
