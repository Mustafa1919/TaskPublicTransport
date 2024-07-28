package com.dw.dto;

import com.dw.entity.Route;
import com.dw.entity.Station;

import java.util.List;

public record StationRequest(
        String stationName,
        String location,
        List<String> routes
) {
    public Station convertToStation(List<Route> route) {
        return new Station(stationName, location, route);
    }
}
