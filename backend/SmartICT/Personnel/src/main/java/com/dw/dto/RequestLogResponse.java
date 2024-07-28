package com.dw.dto;

import com.dw.entities.Request;
import com.dw.enums.ACTION_TYPE;
import com.dw.enums.STATUS;

import java.util.Date;

public record RequestLogResponse(
        ACTION_TYPE actionType,
        String entityName,
        String entityId,
        Date date,
        STATUS status,
        String message
) {
    public static RequestLogResponse fromRequest(Request request) {
        return new RequestLogResponse(
                request.getActionType(),
                request.getEntityName(),
                request.getEntityId(),
                request.getDate(),
                request.getStatus(),
                request.getMessage()
        );
    }
}
