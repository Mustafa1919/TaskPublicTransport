package com.dw.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String stationName;
//    @OneToMany(mappedBy = "station", fetch = FetchType.LAZY)
//    private List<RouteStationRegistration> routes;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "route_station_mapping"
            , joinColumns = @JoinColumn(name = "station_id")
            , inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<Route> routes;

    public Station(String stationName) {
        this.stationName = stationName;
    }
}
