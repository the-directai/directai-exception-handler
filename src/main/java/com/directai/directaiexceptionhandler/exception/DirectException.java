package com.directai.directaiexceptionhandler.exception;

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
    private final DirectExceptionFrame errorFrame;
    private final HttpStatus httpStatus;
    private final List<String> exceptions;

    public DirectException(String message) {
        super(message);
        Assert.hasText(message, "Message is required in this constructor.");
        description = null;
        errorFrame = null;
        httpStatus = null;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, Throwable throwable) {
        super(message, throwable);
        Assert.hasText(message, "Message is required in this constructor.");
        description = null;
        errorFrame = null;
        httpStatus = HttpStatus.BAD_REQUEST;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, String description) {
        super(message);
        Assert.hasText(message, "Message is required in this constructor.");
        Assert.hasText(description, "Description is required in this constructor.");
        this.description = description;
        errorFrame = null;
        httpStatus = HttpStatus.BAD_REQUEST;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, String description, Throwable throwable) {
        super(message, throwable);
        Assert.hasText(message, "Message is required in this constructor.");
        Assert.hasText(description, "Description is required in this constructor.");
        this.description = description;
        errorFrame = null;
        httpStatus = HttpStatus.BAD_REQUEST;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, String description, DirectExceptionFrame errorFrame) {
        super(message);
        Assert.hasText(message, "Message is required in this constructor.");
        Assert.hasText(description, "Description is required in this constructor.");
        Assert.notNull(errorFrame, "Error code is required in this constructor.");
        this.description = description;
        this.errorFrame = errorFrame;
        httpStatus = HttpStatus.BAD_REQUEST;
        exceptions = new ArrayList<>();
    }
    public DirectException(String message, String description, DirectExceptionFrame errorFrame, HttpStatus httpStatus) {
        super(message);
        Assert.hasText(message, "Message is required in this constructor.");
        Assert.hasText(description, "Description is required in this constructor.");
        Assert.notNull(errorFrame, "Error code is required in this constructor.");
        this.description = description;
        this.errorFrame = errorFrame;
        this.httpStatus = httpStatus;
        exceptions = new ArrayList<>();
    }

    public DirectException(String message, String description, DirectExceptionFrame errorFrame, HttpStatus httpStatus, List<String> exceptions) {
        super(message);
        Assert.hasText(message, "Message is required in this constructor.");
        Assert.hasText(description, "Description is required in this constructor.");
        Assert.notNull(errorFrame, "Error code is required in this constructor.");
        this.description = description;
        this.errorFrame = errorFrame;
        this.httpStatus = httpStatus;
        this.exceptions = exceptions;
    }

    public DirectException(String message, String description, DirectExceptionFrame errorFrame, HttpStatus httpStatus, List<String> exceptions, Throwable cause) {
        super(message, cause);
        Assert.hasText(message, "Message is required in this constructor.");
        Assert.hasText(description, "Description is required in this constructor.");
        Assert.notNull(errorFrame, "Error code is required in this constructor.");
        this.description = description;
        this.errorFrame = errorFrame;
        this.httpStatus = httpStatus;
        this.exceptions = exceptions;
    }
}
