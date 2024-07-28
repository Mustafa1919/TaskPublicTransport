package com.dw.controller;

import com.dw.dto.RouteRequest;
import com.dw.dto.RouteResponse;
import com.dw.dto.RouteUpdateRequest;
import com.dw.dto.StationResponse;
import com.dw.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/route")
public class RouteAPI {

    private RouteService routeService;

    @GetMapping("/getAllRoutes")
    public ResponseEntity<List<RouteResponse>> getRoutes() {
        return ResponseEntity.ok(this.routeService.getRoutes());
    }

    @GetMapping("/getRouteByRouteName")
    public ResponseEntity<RouteResponse> getRouteByRouteName(@RequestParam String routeName) {
        return ResponseEntity.ok(this.routeService.getRouteByRouteName(routeName));
    }

    @GetMapping("/getRouteById")
    public ResponseEntity<RouteResponse> getRouteById(@RequestParam String id) {
        return ResponseEntity.ok(this.routeService.getRouteById(id));
    }

    @GetMapping("/getRouteStations")
    public ResponseEntity<StationResponse> getRouteStations(@RequestParam String routeName) {
        return ResponseEntity.ok(this.routeService.getRouteStations(routeName));
    }

    @PostMapping
    public ResponseEntity<RouteResponse> createRoute(@RequestBody RouteRequest routeRequest) {
        return ResponseEntity.ok(this.routeService.createRoute(routeRequest));
    }

    @PutMapping
    public ResponseEntity<RouteResponse> updateRoute(@RequestBody RouteUpdateRequest routeRequest) {
        return ResponseEntity.ok(this.routeService.updateRoute(routeRequest));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteRoute(@RequestParam String routeName) {
        this.routeService.deleteRoute(routeName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
