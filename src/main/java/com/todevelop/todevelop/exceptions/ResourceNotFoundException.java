package com.todevelop.todevelop.exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Setter
@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 6976702623752891881L;
    private static final String DEFAULT_MESSAGE_CODE = "404";
    private String code;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.code = "404";
    }

    public ResourceNotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ResourceNotFoundException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.code = "404";
    }

}
