package com.dw.dto;

import com.dw.entity.Vehicle;
import com.dw.enums.TYPE;

public record VehicleResponse(
        String plateNumber,
        TYPE type,
        int capacity
) {
    public static VehicleResponse fromVehicle(Vehicle vehicle) {
        return new VehicleResponse(vehicle.getPlateNumber(),
                vehicle.getType(), vehicle.getCapacity());
    }
}
