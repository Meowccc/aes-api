package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author
 * @create 2021 - 03 - 05 上午 11:27
 **/
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TimeoutException extends RuntimeException{
}
