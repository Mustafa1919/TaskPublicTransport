package com.dw.dto;

import com.dw.entity.Vehicle;
import com.dw.enums.TYPE;

public record VehicleRequest(
        String plateNumber,
        TYPE type,
        int capacity
) {
    public Vehicle toVehicle() {
        return new Vehicle(plateNumber, type, capacity);
    }
}
