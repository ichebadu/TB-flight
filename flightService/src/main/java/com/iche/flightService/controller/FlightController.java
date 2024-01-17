package com.iche.flightService.controller;

import com.iche.flightService.dto.request.FlightRequest;
import com.iche.flightService.dto.request.FlightResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/flight")
public class FlightController {

    @PostMapping
    public ResponseEntity<FlightResponse> createFlight(@RequestBody FlightRequest flightRequest){
        return ResponseEntity.ok(FlightResponse.builder().build());
    }
}
