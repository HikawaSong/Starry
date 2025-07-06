package com.star.starry.exception;

import com.star.starry.service.MessageUtil;
import lombok.Getter;

@Getter
public class AppException extends RuntimeException{
    private final int code;

    private final String message;

    public AppException(ErrorCode errorCode){
        this.code = errorCode.getErrorCode();
        this.message = MessageUtil.getMessage(errorCode.toString());
    }

}
