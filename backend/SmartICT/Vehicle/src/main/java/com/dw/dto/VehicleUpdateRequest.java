package com.dw.dto;


public record VehicleUpdateRequest(
        String plateNumber,
        int capacity
) {
}
