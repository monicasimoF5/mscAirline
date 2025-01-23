package org.msc.mscAirline.flights;

import org.msc.mscAirline.airports.Airport;
import org.msc.mscAirline.airports.AirportResponse;

import java.time.LocalDateTime;
import java.util.Date;

public record FlightResponse(
        Long flightId,
        String name,
        AirportResponse origin,
        AirportResponse destination,
        int availableSeats,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime
) {
}
