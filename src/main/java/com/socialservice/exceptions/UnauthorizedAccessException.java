package com.socialservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnauthorizedAccessException  extends BaseException{
    public UnauthorizedAccessException(String message){
        super(message,1);
    }
}
