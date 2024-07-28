package com.dw.service;

import com.dw.dto.RouteRequest;
import com.dw.dto.RouteResponse;
import com.dw.dto.RouteUpdateRequest;
import com.dw.dto.StationResponse;
import com.dw.entity.Route;
import com.dw.entity.Station;
import com.dw.exception.ErrorType;
import com.dw.exception.RouteException;
import com.dw.repository.RouteRepository;
import com.dw.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final StationRepository stationRepository;
//    private final RouteStationRegistrationRepository routeStationRegistrationRepository;


    public List<RouteResponse> getRoutes() {
        return this.routeRepository.findAll()
                .stream()
                .map(RouteResponse::fromRoute)
                .collect(Collectors.toList());
    }

    public RouteResponse getRouteByRouteName(String routeName) {
        Route route = this.routeRepository
                .findByRouteName(routeName)
                .orElseThrow( () -> new RouteException(ErrorType.ROUTE_NOT_FOUND));
        return RouteResponse.fromRoute(route);
    }

    public RouteResponse getRouteById(String id) {
        Route route = this.routeRepository
                .findByRouteId(id)
                .orElseThrow( () -> new RouteException(ErrorType.ROUTE_NOT_FOUND));
        return RouteResponse.fromRoute(route);
    }

    public StationResponse getRouteStations(String routeName) {
        // TODO : İçini doldur
        return null;
    }

    public RouteResponse createRoute(RouteRequest routeRequest) {
        List<Station> stationList = createStationsFromString(routeRequest.stationName());
        return RouteResponse
                .fromRoute(this.routeRepository
                        .save(routeRequest.convertToRoute(stationList)));
    }

    public RouteResponse updateRoute(RouteUpdateRequest routeRequest) {
        List<Station> stationList = updateStationsFromString(routeRequest.stations());
        Route route = this.routeRepository
                .findByRouteName(routeRequest.routeName())
                .orElseThrow( () -> new RouteException(ErrorType.ROUTE_NOT_FOUND));
        route.setStations(stationList);
        return RouteResponse
                .fromRoute(this.routeRepository
                        .save(route));
    }

    public void deleteRoute(String routeName) {
        this.routeRepository.deleteByRouteName(routeName);
    }

    private List<Station> createStationsFromString(List<String> stations) {
        List<Station> stationList = new ArrayList<>();
        stations.stream()
                .map(Station::new)
                .forEach( (station) -> {
                    Station s = stationRepository.save(station);
                    stationList.add(s);
                });
        return stationList;
    }

    private List<Station> updateStationsFromString(List<String> stations) {
        List<Station> stationList = new ArrayList<>();
        stations.stream()
                .map(Station::new)
                .forEach( (station) -> {
                    Station s;
                    if (this.stationRepository.existsByStationName(station.getStationName())) {
                        s = stationRepository.findByStationName(station.getStationName());
                    }else{
                        s = stationRepository.save(station);
                    }
                    stationList.add(s);
                });
        return stationList;
    }
}
