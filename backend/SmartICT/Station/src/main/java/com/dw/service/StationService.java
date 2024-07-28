package com.dw.service;

import com.dw.dto.StationRequest;
import com.dw.dto.StationResponse;
import com.dw.dto.StationUpdateRequest;
import com.dw.entity.Route;
import com.dw.entity.Station;
import com.dw.exception.ErrorType;
import com.dw.exception.StationException;
import com.dw.repository.RouteRepository;
import com.dw.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;
    private final RouteRepository routeRepository;

    public List<StationResponse> getStations() {
        return this.stationRepository.findAll()
                .stream()
                .map(StationResponse::fromStation)
                .collect(Collectors.toList());
    }

    public StationResponse getStation(String stationName) {
        Station station = this.stationRepository
                .findByStationName(stationName)
                .orElseThrow( () -> new StationException(ErrorType.STATION_NOT_FOUND));
        return StationResponse.fromStation(station);
    }

    public StationResponse createStation(StationRequest stationRequest) {
        List<Route> routeList = createRoutesFromString(stationRequest.routes());
        return StationResponse
                .fromStation(this.stationRepository
                        .save(stationRequest.convertToStation(routeList)));
    }

    public StationResponse updateStation(StationUpdateRequest stationRequest) {
        List<Route> routeList = updateRoutesFromString(stationRequest.routes());
        Station station = this.stationRepository
                .findByStationName(stationRequest.stationName())
                .orElseThrow( () -> new StationException(ErrorType.STATION_NOT_UPDATE));
        station.setRoutes(routeList);
        return StationResponse
                .fromStation(this.stationRepository
                        .save(station));
    }

    public void deleteStation(String stationName) {
        this.stationRepository.deleteByStationName(stationName);
    }

    private List<Route> createRoutesFromString(List<String> routes) {
        List<Route> routeList = new ArrayList<>();
        routes.stream()
                .map(Route::new)
                .forEach( (route) -> {
                    Route s = routeRepository.save(route);
                    routeList.add(s);
                });
        return routeList;
    }

    private List<Route> updateRoutesFromString(List<String> routes) {
        List<Route> routeList = new ArrayList<>();
        routes.stream()
                .map(Route::new)
                .forEach( (route) -> {
                    Route s;
                    if (this.routeRepository.existsByRouteName(route.getRouteName())) {
                        s = routeRepository.findByRouteName(route.getRouteName());
                    }else{
                        s = routeRepository.save(route);
                    }
                    routeList.add(s);
                });
        return routeList;
    }
}
