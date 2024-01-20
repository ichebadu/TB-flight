package com.iche.flightService.controller;

import com.iche.flightService.dto.request.FlightRequest;
import com.iche.flightService.dto.request.FlightResponse;
import com.iche.flightService.flightService.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/flight")
public class FlightController {

    private final FlightService flightService;
    @PostMapping
    public ResponseEntity<FlightResponse> createFlight(@RequestBody FlightRequest flightRequest){
        var flight = flightService.createFlight(flightRequest);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<FlightResponse>> getAllFlight(){
        return new ResponseEntity<>(flightService.getAllFlight(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getFlightByNumber(@PathVariable ("id") String flightNumber){
        return new ResponseEntity<>(flightService.getFlightByNumber(flightNumber), HttpStatus.OK);
    }

}
