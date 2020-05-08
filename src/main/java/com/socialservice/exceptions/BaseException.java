package com.socialservice.exceptions;

import lombok.Data;

@Data
public abstract class BaseException extends Exception {

    private int code;

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

}
