package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonnelException extends RuntimeException {
    private final ErrorType errorType;
}