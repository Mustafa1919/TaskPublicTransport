package com.dw.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class ErrorMessage {

    private final int code;
    private final String message;
    @Builder.Default
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final HttpStatus httpStatus;
}
