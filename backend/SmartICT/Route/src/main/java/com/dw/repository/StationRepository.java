package com.dw.repository;

import com.dw.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, String> {

    boolean existsByStationName(String name);
    Station findByStationName(String stationName);
    List<Station> findBy(String stationName);

}
