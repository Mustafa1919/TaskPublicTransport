package com.dw.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String stationId;

    @Column(unique = true)
    private String stationName;
    private String stationLocation; // Entity si oluşturulmalı

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "route_station_mapping"
            , joinColumns = @JoinColumn(name = "station_id")
            , inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<Route> routes;

    public Station(String stationName, String stationLocation, List<Route> routes) {
        this.stationName = stationName;
        this.stationLocation = stationLocation;
        this.routes = routes;
    }
}
