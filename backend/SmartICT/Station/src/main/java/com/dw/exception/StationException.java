package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StationException extends RuntimeException {
    private final ErrorType errorType;
}
