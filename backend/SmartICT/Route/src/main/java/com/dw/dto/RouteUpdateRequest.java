package com.dw.dto;

import java.util.List;

public record RouteUpdateRequest(
        String routeName,
        List<String> stations
) {
}
