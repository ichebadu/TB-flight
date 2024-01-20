package com.iche.flightService.flightService;

import com.iche.flightService.dto.request.FlightRequest;
import com.iche.flightService.dto.request.FlightResponse;
import com.iche.flightService.entity.Flight;
import com.iche.flightService.exception.FlightServiceCustomException;
import com.iche.flightService.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class FlightServiceImpl implements FlightService{

    private final FlightRepository flightRepository;

    @Override
    public FlightResponse createFlight(FlightRequest flightRequest) {

        Flight flight  = Flight.builder()
                .flightNumber(flightRequest.flightNumber())
                .origin(flightRequest.origin())
                .departureDate(flightRequest.departureDate())
                .arrivalDate(flightRequest.arrivalDate())
                .totalSeats(flightRequest.totalSeats())
                .availableSeats(flightRequest.availableSeats())
                .amount(flightRequest.amount())
                .build();


        flightRepository.save(flight);

        FlightResponse flightResponse = new FlightResponse();
        BeanUtils.copyProperties(flight,flightResponse);

        log.info("Flight created {}",flightResponse.getFlightId());
        return flightResponse;
    }

    @Override
    public List<FlightResponse> getAllFlight() {
        List<Flight> flights = flightRepository.findAll();
        List<FlightResponse> responses = flights.stream()
                .map(this::mapToFlightResponse)
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public FlightResponse getFlightByNumber(String flightNumber) {
        Flight flight= flightRepository.findByFlightNumber(flightNumber).orElseThrow(
                () -> new FlightServiceCustomException("Flight with given id {} not found", "FLIGHT_NOT_FOUND")
        );

        FlightResponse flightResponse = new FlightResponse();
        BeanUtils.copyProperties(flight,flightResponse);
        return flightResponse;
    }

    private FlightResponse mapToFlightResponse(Flight flight) {
        FlightResponse flightResponse = new FlightResponse();
        BeanUtils.copyProperties(flight, flightResponse);
        return flightResponse;
    }
}
