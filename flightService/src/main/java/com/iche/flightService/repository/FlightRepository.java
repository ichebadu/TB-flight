package com.iche.flightService.repository;

import com.iche.flightService.entity.Flight;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight,Long> {
    Optional<Flight> findByFlightNumber(String flightNumber);
}
