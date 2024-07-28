package com.dw.repository;

import com.dw.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, String> {
    boolean existsByRouteName(String name);
    Route findByRouteName(String name);

}
