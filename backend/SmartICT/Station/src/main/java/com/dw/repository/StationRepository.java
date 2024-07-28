package com.dw.repository;

import com.dw.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, String> {
    Optional<Station> findByStationName(String name);
    void deleteByStationName(String stationName);
}
