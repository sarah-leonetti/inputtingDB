package com.iaustin.ggsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EducationItemNotFoundException extends RuntimeException {

    public EducationItemNotFoundException(String message) {
        super(message);
    }
}