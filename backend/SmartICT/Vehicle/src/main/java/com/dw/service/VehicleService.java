package com.dw.service;

import com.dw.dto.VehicleRequest;
import com.dw.dto.VehicleResponse;
import com.dw.dto.VehicleUpdateRequest;
import com.dw.entity.Vehicle;
import com.dw.enums.TYPE;
import com.dw.exception.ErrorType;
import com.dw.exception.VehicleException;
import com.dw.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public List<VehicleResponse> getAllVehicle() {
        return this.vehicleRepository.findAll()
                .stream()
                .map(VehicleResponse::fromVehicle)
                .collect(Collectors.toList());
    }

    public VehicleResponse getVehicleByPlateNumber(String plateNumber) {
        Vehicle vehicle = this.vehicleRepository
                .findByPlateNumber(plateNumber)
                .orElseThrow(() -> new VehicleException(ErrorType.VEHICLE_NOT_FOUND));
        return VehicleResponse.fromVehicle(vehicle);
    }

    public List<VehicleResponse> getVehicleByType(int type) {
        return this.vehicleRepository.findByType(TYPE.getType(type))
                .stream()
                .map(VehicleResponse::fromVehicle)
                .collect(Collectors.toList());
    }

    public VehicleResponse defineVehicle(VehicleRequest vehicleRequest) {
        return VehicleResponse.fromVehicle(
                this.vehicleRepository.save(vehicleRequest.toVehicle()));
    }

    public VehicleResponse updateVehicle(VehicleUpdateRequest vehicleRequest) {
        if (this.vehicleRepository.existsByPlateNumber(vehicleRequest.plateNumber())){
            Vehicle vehicle = this.vehicleRepository
                    .findByPlateNumber(vehicleRequest.plateNumber())
                    .orElseThrow(() -> new VehicleException(ErrorType.VEHICLE_NOT_FOUND));
            vehicle.setCapacity(vehicleRequest.capacity());
            return VehicleResponse.fromVehicle(
                    this.vehicleRepository.save(vehicle));
        }else{
            throw new VehicleException(ErrorType.VEHICLE_NOT_UPDATE);
        }
    }

    public void deleteVehicle(String plateNumber) {
        this.vehicleRepository.deleteByPlateNumber(plateNumber);
    }
}
