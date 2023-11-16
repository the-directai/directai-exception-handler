package com.directai.directaiexceptionhandler.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

@Getter
@Setter
public class DirectExceptionFrame {
    private final String errorCode;
    private final String errorName;

    public DirectExceptionFrame(String errorCode, String errorName) {
        Assert.hasText(errorCode, "Error code is required in this constructor.");
        Assert.hasText(errorName, "Error name is required in this constructor.");
        this.errorCode = errorCode;
        this.errorName = errorName;
    }
}
