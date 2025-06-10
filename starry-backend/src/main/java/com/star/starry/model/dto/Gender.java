package com.star.starry.model.dto;

public enum Gender {
    MALE(1),

    FEMALE(0),

    UNDEFINED(-1);

    private Integer value;

    Gender(Integer value) {
        this.value = value;
    }
}
