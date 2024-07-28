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
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String routeId;

    @Column(unique = true)
    private String routeName;
    private String routeDescription;
//    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
//    private List<RouteStationRegistration> stations;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "route_station_mapping"
            , joinColumns = @JoinColumn(name = "route_id")
            , inverseJoinColumns = @JoinColumn(name = "station_id"))
    private List<Station> stations;

    public Route(String routeName, String routeDescription, List<Station> stations) {
        this.routeName = routeName;
        this.routeDescription = routeDescription;
        this.stations = stations;
    }
}
