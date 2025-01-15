package org.msc.mscAirline.flights;

import org.msc.mscAirline.airports.Airport;

import java.util.Date;

public record FlightResponse(
        Long id,
        Airport origin,
        Airport destination,
        int availableSeats,
        Date departureTime,
        Date arrivalTime
) {
}
