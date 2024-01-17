package com.iche.flightService.dto.request;

import java.time.LocalDate;

public record FlightRequest(
        String flightNumber,
        String origin,
        LocalDate departureDate,
        LocalDate arrivalDate,
        int totalSeats,
        int availableSeats,
        double amount
) {

}