package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RouteException extends RuntimeException {
    private final ErrorType errorType;
}
