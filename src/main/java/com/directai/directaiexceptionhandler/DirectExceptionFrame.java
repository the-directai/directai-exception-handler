package com.directai.directaiexceptionhandler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

@Getter
@Setter
public class DirectExceptionFrame {
    private final String errorCode;
    private final String errorName;

    public DirectExceptionFrame(String errorCode, String errorName) {
        Assert.hasText(errorCode, "error code should have text");
        Assert.hasText(errorCode, "error name should have text");
        this.errorCode = errorCode;
        this.errorName = errorName;
    }
}
