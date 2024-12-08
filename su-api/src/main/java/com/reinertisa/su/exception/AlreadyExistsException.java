package com.reinertisa.su.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistsException extends Exception {
    private String fieldName;

    public AlreadyExistsException() {
        super();
    }

    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }
}
