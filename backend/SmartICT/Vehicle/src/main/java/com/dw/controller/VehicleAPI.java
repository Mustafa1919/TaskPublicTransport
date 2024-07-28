package com.dw.controller;

import com.dw.dto.VehicleRequest;
import com.dw.dto.VehicleResponse;
import com.dw.dto.VehicleUpdateRequest;
import com.dw.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicle")
@RequiredArgsConstructor
public class VehicleAPI {

    private final VehicleService vehicleService;

    @GetMapping("/getVehicles")
    public ResponseEntity<List<VehicleResponse>> getAllVehicles(){
        return ResponseEntity.ok(this.vehicleService.getAllVehicle());
    }

    @GetMapping("/getVehicleByPlateNumber")
    public ResponseEntity<VehicleResponse> getVehicleByPlateNumber(@RequestParam String plateNumber){
        return ResponseEntity.ok(this.vehicleService.getVehicleByPlateNumber(plateNumber));
    }

    @GetMapping("/getVehicleByType")
    public ResponseEntity<List<VehicleResponse>> getVehicleByType(@RequestParam int type){
        return ResponseEntity.ok(this.vehicleService.getVehicleByType(type));
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> defineVehicle(@RequestBody VehicleRequest vehicleRequest){
        return ResponseEntity.ok(this.vehicleService.defineVehicle(vehicleRequest));
    }

    @PutMapping
    public ResponseEntity<VehicleResponse> updateVehicle(@RequestBody VehicleUpdateRequest vehicleRequest){
        return ResponseEntity.ok(this.vehicleService.updateVehicle(vehicleRequest));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteVehicle(@RequestParam String plateNumber){
        this.vehicleService.deleteVehicle(plateNumber);
        return ResponseEntity.ok().build();
    }
}
