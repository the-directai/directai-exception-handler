package com.directai.directaiexceptionhandler.exception;

import com.directai.directaiexceptionhandler.MessageGenerator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DirectException extends Exception {
    private final String description;
    private final DirectExceptionFrame errorCode;
    private final HttpStatus httpStatus;
    private final List<String> exceptions;

    public DirectException(String message) {
        super(message);
        Assert.hasText(message, MessageGenerator.generateMessageConstructor("Message"));
        description = null;
        errorCode = null;
        httpStatus = null;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, Throwable throwable) {
        super(message, throwable);
        Assert.hasText(message, MessageGenerator.generateMessageConstructor("Message"));
        description = null;
        errorCode = null;
        httpStatus = HttpStatus.BAD_REQUEST;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, String description) {
        super(message);
        Assert.hasText(message, MessageGenerator.generateMessageConstructor("Message"));
        Assert.hasText(description, MessageGenerator.generateMessageConstructor("Description"));
        this.description = description;
        errorCode = null;
        httpStatus = HttpStatus.BAD_REQUEST;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, String description, Throwable throwable) {
        super(message, throwable);
        Assert.hasText(message, MessageGenerator.generateMessageConstructor("Message"));
        Assert.hasText(description, MessageGenerator.generateMessageConstructor("Description"));
        this.description = description;
        errorCode = null;
        httpStatus = HttpStatus.BAD_REQUEST;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, String description, DirectExceptionFrame errorCode) {
        super(message);
        Assert.hasText(message, MessageGenerator.generateMessageConstructor("Message"));
        Assert.hasText(description, MessageGenerator.generateMessageConstructor("Description"));
        Assert.notNull(errorCode, MessageGenerator.generateMessageConstructor("Error code"));
        this.description = description;
        this.errorCode = errorCode;
        httpStatus = HttpStatus.BAD_REQUEST;
        exceptions = new ArrayList<>();
    }
    public DirectException(String message, String description, DirectExceptionFrame errorCode, HttpStatus httpStatus) {
        super(message);
        Assert.hasText(message, MessageGenerator.generateMessageConstructor("Message"));
        Assert.hasText(description, MessageGenerator.generateMessageConstructor("Description"));
        Assert.notNull(errorCode, MessageGenerator.generateMessageConstructor("Error code"));
        this.description = description;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, String description, DirectExceptionFrame errorCode, HttpStatus httpStatus, List<String> exceptions) {
        super(message);
        Assert.hasText(message, MessageGenerator.generateMessageConstructor("Message"));
        Assert.hasText(description, MessageGenerator.generateMessageConstructor("Description"));
        Assert.notNull(errorCode, MessageGenerator.generateMessageConstructor("Error code"));
        this.description = description;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.exceptions = exceptions;
    }

    public DirectException(String message, String description, DirectExceptionFrame errorCode, HttpStatus httpStatus, List<String> exceptions, Throwable cause) {
        super(message, cause);
        Assert.hasText(message, MessageGenerator.generateMessageConstructor("Message"));
        Assert.hasText(description, MessageGenerator.generateMessageConstructor("Description"));
        Assert.notNull(errorCode, MessageGenerator.generateMessageConstructor("Error code"));
        this.description = description;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.exceptions = exceptions;
    }
}
