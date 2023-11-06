package com.directai.directaiexceptionhandler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorModel {
    private String errorCode;
    private String errorName;
    private String description;
}
