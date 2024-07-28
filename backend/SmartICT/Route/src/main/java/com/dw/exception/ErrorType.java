package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType {

    INVALID_PARAMETER (1001, "Geçersiz parametre girişi yaptınız.", HttpStatus.BAD_REQUEST),
    ROUTE_NOT_FOUND(1002, "Güzergah Bulunamadı.", HttpStatus.NOT_FOUND),
    ROUTE_NOT_UPDATE(1003, "Bu Güzergah güncellenemedi.", HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;

}
