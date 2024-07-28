package com.dw.dto;

import com.dw.entity.Station;

public record StationResponse(
        String stationName,
        String location
) {
    public static StationResponse fromStation(Station station) {
        return new StationResponse(
                station.getStationName(),
                station.getStationLocation()
        );
    }
}
