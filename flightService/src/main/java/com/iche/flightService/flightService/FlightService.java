package com.iche.flightService.flightService;

import com.iche.flightService.dto.request.FlightRequest;
import com.iche.flightService.dto.request.FlightResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FlightService {
    FlightResponse createFlight(@RequestBody FlightRequest flightRequest);

    List<FlightResponse> getAllFlight();

    FlightResponse getFlightByNumber(String flightNumber);
}
