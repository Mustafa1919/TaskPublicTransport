package com.dw.dto;

import com.dw.entity.Route;
import com.dw.entity.Station;

import java.util.List;

public record RouteRequest(
        String routeName,
        String routeDescription,
        List<String> stationName
) {
    public Route convertToRoute(List<Station> stations) {
        return new Route(routeName, routeDescription, stations);
    }
}
