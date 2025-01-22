package org.msc.mscAirline.flights;

import org.msc.mscAirline.airports.Airport;
import org.msc.mscAirline.airports.AirportResponse;

import java.util.Date;

public record FlightResponse(
        Long flightId,
        String flightName,
        AirportResponse origin,
        AirportResponse destination,
        int availableSeats,
        Date departureTime,
        Date arrivalTime
) {
}
