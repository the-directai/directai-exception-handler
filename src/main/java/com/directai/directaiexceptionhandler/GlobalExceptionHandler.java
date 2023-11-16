package com.directai.directaiexceptionhandler;

import com.directai.directaiexceptionhandler.exception.DirectException;
import com.directai.directaiexceptionhandler.model.ErrorModel;
import com.directai.directaiexceptionhandler.model.ErrorModelMultipleExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorModel> handleDirectException(Exception exception) {
        log.error("Exception occurred", exception);
        if (exception instanceof DirectException) {
            DirectException directException = (DirectException) exception;
            if (directException.getExceptions().isEmpty()) {
                ErrorModel model = ErrorModel.builder()
                        .errorCode(directException.getErrorFrame().getErrorCode())
                        .description(directException.getDescription())
                        .errorName(directException.getErrorFrame().getErrorName())
                        .build();
                return new ResponseEntity<>(model, new HttpHeaders(), directException.getHttpStatus());
            } else {
                ErrorModelMultipleExceptions model = new ErrorModelMultipleExceptions(directException.getErrorFrame().getErrorCode(),
                        directException.getErrorFrame().getErrorName(), directException.getDescription(), directException.getExceptions());
                return new ResponseEntity<>(model, new HttpHeaders(), directException.getHttpStatus());
            }
        } else {
            ErrorModel model = ErrorModel.builder()
                    .errorCode(DirectServerExceptionCode.D5000.getErrorCode())
                    .description("An unknown exception occurred")
                    .errorName(DirectServerExceptionCode.D5000.getErrorName())
                    .build();
            return new ResponseEntity<>(model, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
