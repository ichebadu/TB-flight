package com.iche.flightService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FlightResponse {
    private Long flightId;

    private String flightNumber;
    private String origin;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private int totalSeats;
    private int availableSeats;
    private double amount;

}
