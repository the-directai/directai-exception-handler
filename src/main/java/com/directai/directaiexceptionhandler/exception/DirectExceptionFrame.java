package com.directai.directaiexceptionhandler.exception;

import com.directai.directaiexceptionhandler.MessageGenerator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

@Getter
@Setter
public class DirectExceptionFrame {
    private final String errorCode;
    private final String errorName;

    public DirectExceptionFrame(String errorCode, String errorName) {
        Assert.hasText(errorCode, MessageGenerator.generateMessageConstructor("Error code"));
        Assert.hasText(errorCode, MessageGenerator.generateMessageConstructor("Error name"));
        this.errorCode = errorCode;
        this.errorName = errorName;
    }
}
