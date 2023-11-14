package com.directai.directaiexceptionhandler.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ErrorModelMultipleExceptions extends ErrorModel {
    List<String> errors;

    public ErrorModelMultipleExceptions(String errorCode, String errorName, String description) {
        super(errorCode, errorName, description);
    }

    public ErrorModelMultipleExceptions(String errorCode, String errorName, String description, List<String> errors) {
        super(errorCode, errorName, description);
        this.errors = errors;
    }
}
