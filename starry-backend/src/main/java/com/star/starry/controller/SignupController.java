package com.star.starry.controller;

import com.star.starry.model.dto.Account;
import com.star.starry.model.form.SignupForm;
import com.star.starry.service.SignupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SignupController {
    @Autowired
    private SignupService service;

    @PostMapping("/signup")
    public ResponseEntity<Account> signup(@RequestBody @Valid SignupForm form){
        System.out.println("Received SignupForm: " + form);

        var account = service.signup(form);

        account.setPassword(null);

        return ResponseEntity.ok().body(account);
    }

}
