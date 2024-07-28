package com.dw.dto;

import com.dw.entity.Route;

public record RouteResponse(
        String routeName,
        String routeDescription
) {
    public static RouteResponse fromRoute(Route route) {
        return new RouteResponse(
                route.getRouteName(),
                route.getRouteDescription()
        );
    }
}
