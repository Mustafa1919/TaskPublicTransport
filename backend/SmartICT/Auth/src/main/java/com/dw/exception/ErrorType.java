package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType {

    INVALID_PARAMETER (1001, "Geçersiz parametre girişi yaptınız.", HttpStatus.BAD_REQUEST),
    REGISTER_PASSWORD_MISMATCH (1002, "Girilen parolalar uyuşmadı.", HttpStatus.BAD_REQUEST),
    REGISTER_USERNAME_EXISTS (1003, "Bu kullanici adi sistemde alinmiştir.", HttpStatus.BAD_REQUEST),
    LOGIN_USERNAME_OR_PASSWORD_MISMATCH  (1004, "Kullanıcı veya parola adi hatalı.", HttpStatus.BAD_REQUEST),
    INVALID_TOKEN (2001, "Geçersiz token.", HttpStatus.BAD_REQUEST),
    TOKEN_EXPIRE (2002, "Token Süresi Geçmiş.", HttpStatus.BAD_REQUEST),
    TOKEN_UNSUPPORTED (2003, "Desteklenmeyen token.", HttpStatus.BAD_REQUEST),
    BAD_REQUEST (4000, "Geçersiz istek yaptınız.", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR (5000, "Geçersiz parametre girişi yaptınız.", HttpStatus.INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    private HttpStatus httpStatus;

}
