package com.directai.directaiexceptionhandler;

import com.directai.directaiexceptionhandler.model.ErrorModel;
import com.directai.directaiexceptionhandler.model.ErrorModelMultipleExceptions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DirectException.class)
    ResponseEntity<ErrorModel> handleDirectException(DirectException ex){
        if(ex.getExceptions().isEmpty()){
            ErrorModel model = new ErrorModel(ex.getErrorCode().getErrorCode(),
                    ex.getErrorCode().getErrorName(), ex.getDescription());
            return new ResponseEntity<>(model, new HttpHeaders(), ex.getHttpStatus());
        }else{
            ErrorModelMultipleExceptions model = new ErrorModelMultipleExceptions(ex.getErrorCode().getErrorCode(),
                    ex.getErrorCode().getErrorName(), ex.getDescription(), ex.getExceptions());
            return new ResponseEntity<>(model, new HttpHeaders(), ex.getHttpStatus());
        }
    }

}
