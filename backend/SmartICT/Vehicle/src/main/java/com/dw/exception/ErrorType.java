package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType {

    INVALID_PARAMETER (1001, "Geçersiz parametre girişi yaptınız.", HttpStatus.BAD_REQUEST),
    VEHICLE_NOT_FOUND(1002, "Araç Bulunamadı.", HttpStatus.NOT_FOUND),
    VEHICLE_NOT_UPDATE(1003, "Bu Araç güncellenemedi.", HttpStatus.BAD_REQUEST),
    TYPE_NOT_FOUND(1004, "Araç Tipi Bulunamadı.", HttpStatus.BAD_REQUEST),
    PLATE_NOT_EMPTY(1005, "Araç Plakası Boş Olamaz.", HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;

}
