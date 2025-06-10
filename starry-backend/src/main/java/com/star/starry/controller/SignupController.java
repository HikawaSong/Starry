package com.star.starry.controller;

import com.star.starry.model.form.SignupForm;
import com.star.starry.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void signup(@RequestBody SignupForm form){
        System.out.println("Received SignupForm: " + form);
        checkParameters(form);
        service.signup(form);
    }

    private void checkParameters(SignupForm form) {

    }
}
