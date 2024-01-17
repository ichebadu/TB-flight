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
    String flightNumber;
    String origin;
    LocalDate departureDate;
    LocalDate arrivalDate;
    int totalSeats;
    int availableSeats;
    double amount;

}
