package com.dw.repository;

import com.dw.entity.Vehicle;
import com.dw.enums.TYPE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Optional<Vehicle> findByPlateNumber(String plateNumber);
    List<Vehicle> findByType(TYPE type);
    void deleteByPlateNumber(String plateNumber);
    boolean existsByPlateNumber(String plateNumber);
}
