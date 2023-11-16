package com.directai.directaiexceptionhandler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorModel {
    private String errorCode;
    private String errorName;
    private String description;
}
