package com.dw.dto;

import com.dw.entities.Request;
import com.dw.enums.ACTION_TYPE;
import com.dw.enums.STATUS;

public record RequestLog(
        ACTION_TYPE actionType,
        String entityName,
        String entityId,
        STATUS status,
        String message
) {
    public Request toRequest() {
        return new Request(
                actionType,
                entityName,
                entityId,
                status,
                message
        );
    }
}
