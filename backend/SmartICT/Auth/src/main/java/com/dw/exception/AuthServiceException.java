package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthServiceException extends RuntimeException {

    private final ErrorType errorType;
}
