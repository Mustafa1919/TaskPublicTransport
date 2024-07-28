package com.dw.controller;

import com.dw.dto.StationRequest;
import com.dw.dto.StationResponse;
import com.dw.dto.StationUpdateRequest;
import com.dw.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/station")
@RequiredArgsConstructor
public class StationAPI {

    private final StationService stationService;

    @GetMapping("/getAllStations")
    public ResponseEntity<List<StationResponse>> getStations() {
        return ResponseEntity.ok(this.stationService.getStations());
    }

    @GetMapping("/getStation")
    public ResponseEntity<StationResponse> getStation(@RequestParam String stationName ) {
        return ResponseEntity.ok(this.stationService.getStation(stationName));
    }

    @PostMapping
    public ResponseEntity<StationResponse> createStation(@RequestBody StationRequest stationRequest) {
        return ResponseEntity.ok(this.stationService.createStation(stationRequest));
    }

    @PutMapping
    public ResponseEntity<StationResponse> updateStation(@RequestBody StationUpdateRequest stationRequest) {
        return ResponseEntity.ok(this.stationService.updateStation(stationRequest));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteStation(@RequestParam String stationName) {
        this.stationService.deleteStation(stationName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
