package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author
 * @create 2021 - 03 - 05 上午 11:12
 **/
@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotAuthorizedException extends RuntimeException{
    public NotAuthorizedException(String message) {
        super(message);
    }
}
