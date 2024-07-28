package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType {

    INVALID_PARAMETER (1001, "Geçersiz parametre girişi yaptınız.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND (1002, "Kullanıcı Bulunamadı.", HttpStatus.NOT_FOUND),
    USER_NOT_UPDATE (1003, "Bu kullanici güncellenemedi.", HttpStatus.BAD_REQUEST),
    STATUS_NOT_FOUND (1004, "Status Bilgisi Tanımlı Değil.", HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;

}
