package com.example.demo.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserInactive extends RuntimeException{
    public UserInactive(String message){
        super(message);
    }
}
