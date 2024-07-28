package com.dw.enums;

import com.dw.exception.ErrorType;
import com.dw.exception.VehicleException;

public enum TYPE {
    BUS,
    TRAM,
    METRO;

    public static TYPE getType(int value) {
        return switch (value) {
            case 0 -> TYPE.BUS;
            case 1 -> TYPE.TRAM;
            case 2 -> TYPE.METRO;
            default -> throw new VehicleException(ErrorType.TYPE_NOT_FOUND);
        };
    }
}
