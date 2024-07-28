package com.dw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

    @ExceptionHandler(PersonnelException.class)
    public ResponseEntity<ErrorMessage> handleException(PersonnelException ex){
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .message(ex.getErrorType().getMessage())
                .code(ex.getErrorType().getCode())
                .httpStatus(ex.getErrorType().getHttpStatus())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getErrorType().getHttpStatus());
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<ErrorMessage> handleException(RequestException ex){
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .message(ex.getErrorType().getMessage())
                .code(ex.getErrorType().getCode())
                .httpStatus(ex.getErrorType().getHttpStatus())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getErrorType().getHttpStatus());
    }
}
