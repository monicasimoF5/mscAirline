package org.msc.mscAirline.flights;

import org.msc.mscAirline.airports.AirportResponse;

import java.time.LocalDateTime;

public record FlightResponse(
        Long flightId,
        String name,
        AirportResponse origin,
        AirportResponse destination,
        int availableSeats,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        boolean statusFlight
) {
}
