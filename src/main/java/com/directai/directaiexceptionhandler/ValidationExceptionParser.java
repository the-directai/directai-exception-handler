package com.directai.directaiexceptionhandler;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationExceptionParser {
    private ValidationExceptionParser() {
    }

    public static List<String> getValidationMessage(BindingResult bindingResult) {
        return bindingResult.getAllErrors()
                .stream()
                .map(ValidationExceptionParser::getValidationMessage)
                .collect(Collectors.toList());
    }

    private static String getValidationMessage(ObjectError error) {
        if (error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            String className = fieldError.getObjectName();
            String property = fieldError.getField();
            Object invalidValue = fieldError.getRejectedValue();
            String message = fieldError.getDefaultMessage();
            return String.format("%s.%s %s, but it was %s", className, property, message, invalidValue);
        }
        return String.format("%s: %s", error.getObjectName(), error.getDefaultMessage());
    }
}