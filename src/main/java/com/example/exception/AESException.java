package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author
 * @create 2021 - 03 - 05 下午 01:36
 **/
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AESException extends RuntimeException{

    public AESException() {
    }
    public AESException(String message) {
        super(message);
    }
}
