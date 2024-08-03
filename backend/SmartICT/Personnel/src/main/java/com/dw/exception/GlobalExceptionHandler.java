package com.dw.exception;

import com.dw.dto.RequestLog;
import com.dw.enums.ACTION_TYPE;
import com.dw.enums.STATUS;
import com.dw.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final RequestService requestService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex){
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .message("Beklenmedik Hata : " + ex.getMessage())
                .code(9000)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        requestService.createRequestLog(
                new RequestLog(ACTION_TYPE.GET,
                        "Personnel",
                        "",
                        STATUS.FAIL,
                        errorMessage.getMessage())
        );
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

        requestService.createRequestLog(
                new RequestLog(ACTION_TYPE.GET,
                        "Personnel",
                        "",
                        STATUS.FAIL,
                        errorMessage.getMessage())
        );
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

        requestService.createRequestLog(
                new RequestLog(ACTION_TYPE.GET,
                        "Request",
                        "",
                        STATUS.FAIL,
                        errorMessage.getMessage())
        );
        return new ResponseEntity<>(errorMessage, ex.getErrorType().getHttpStatus());
    }
}
