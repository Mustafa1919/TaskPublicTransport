package com.dw.repository;

import com.dw.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {
    Optional<Route> findByRouteName(String routeName);
    Optional<Route> findByRouteId(String id);
    void deleteByRouteName(String routeName);
}
