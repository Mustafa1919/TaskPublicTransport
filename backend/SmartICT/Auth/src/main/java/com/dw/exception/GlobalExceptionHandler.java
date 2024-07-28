package com.dw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex){
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .message("Beklenmedik Hata : " + ex.getMessage())
                .code(9000)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthServiceException.class)
    public ResponseEntity<ErrorMessage> handleException(AuthServiceException ex){
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .message(ex.getErrorType().getMessage())
                .code(ex.getErrorType().getCode())
                .httpStatus(ex.getErrorType().getHttpStatus())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getErrorType().getHttpStatus());
    }

}
