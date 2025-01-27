package org.msc.mscAirline.flights;

import org.msc.mscAirline.airports.Airport;
import org.msc.mscAirline.airports.AirportMapper;

public class FlightMapper {
    public static Flight toEntity(FlightRequest flightRequest, Airport airportOrigin, Airport airportDestination) {
        return new Flight(
                flightRequest.name(),
                airportOrigin,
                airportDestination,
                flightRequest.availableSeats(),
                flightRequest.departureTime(),
                flightRequest.arrivalTime(),
                flightRequest.statusFlight()
        );
    }

    public static FlightResponse toResponse(Flight flight) {
        return new FlightResponse(
                flight.getFlightId(),
                flight.getName(),
                AirportMapper.toResponse(flight.getOrigin()),
                AirportMapper.toResponse(flight.getDestination()),
                flight.getAvailableSeats(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.isStatusFlight()
        );
    }
}
