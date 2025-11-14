package com.star.starry.model.account;

import lombok.Getter;

@Getter
public enum Gender {
    MALE(1),

    FEMALE(0),

    UNDEFINED(-1);

    private final Integer value;

    Gender(Integer value) {
        this.value = value;
    }
}
