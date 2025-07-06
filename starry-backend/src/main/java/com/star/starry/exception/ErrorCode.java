package com.star.starry.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_NAME_DUPLICATED(1001);

    private final int errorCode;

    ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
