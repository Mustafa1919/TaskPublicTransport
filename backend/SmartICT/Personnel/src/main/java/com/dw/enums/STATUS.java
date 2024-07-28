package com.dw.enums;

import com.dw.exception.ErrorType;
import com.dw.exception.RequestException;

public enum STATUS {
    SUCCESS,
    FAIL,
    CONTINUE;

    public static STATUS getStatus(int value) {
        return switch (value) {
            case 0 -> STATUS.SUCCESS;
            case 1 -> STATUS.FAIL;
            case 2 -> STATUS.CONTINUE;
            default -> throw new RequestException(ErrorType.STATUS_NOT_FOUND);
        };
    }
}
