package com.dw.dto;

import java.util.List;

public record StationUpdateRequest(
        String stationName,
        String location,
        List<String> routes
) {
}
