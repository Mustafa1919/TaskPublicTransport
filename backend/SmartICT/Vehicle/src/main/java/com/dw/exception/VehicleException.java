package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VehicleException extends RuntimeException {
    private final ErrorType errorType;
}
