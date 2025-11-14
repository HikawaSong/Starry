package com.star.starry.service;

import com.star.starry.dao.SignupDao;
import com.star.starry.exception.AppException;
import com.star.starry.exception.ErrorCode;
import com.star.starry.model.account.Account;
import com.star.starry.model.account.Gender;
import com.star.starry.model.account.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class SignupService {
    @Autowired
    private SignupDao dao;


    public Account signup(SignupForm form) {
        checkNameDuplicated(form.getName());

        var id = UUID.randomUUID().toString();
        var gender = form.getGender() == null ? Gender.UNDEFINED : Gender.valueOf(form.getGender());
        var birthday = form.getBirthday() == null ? null : LocalDate.parse(form.getBirthday());

        var account = Account.builder()
                .id(id)
                .name(form.getName())
                .email(form.getEmail())
                .password(form.getPassword())
                .gender(gender)
                .birthday(birthday)
                .build();

        return dao.save(account);
    }

    private void checkNameDuplicated(String name) {
        boolean existed = dao.existsByName(name);
        if (existed) throw new AppException(ErrorCode.USER_NAME_DUPLICATED);
    }
}
