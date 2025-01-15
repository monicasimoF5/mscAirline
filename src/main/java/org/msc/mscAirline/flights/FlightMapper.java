package org.msc.mscAirline.flights;



public class FlightMapper {
    public static Flight toEntity(FlightRequest flightRequest) {
        return new Flight(
                flightRequest.origin(),
                flightRequest.destination(),
                flightRequest.availableSeats(),
                flightRequest.departureTime(),
                flightRequest.arrivalTime()
        );
    }

    public static FlightResponse toResponse(Flight flight) {
        return new FlightResponse(
                flight.getId(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getAvailableSeats(),
                flight.getDepartureTime(),
                flight.getArrivalTime()
        );
    }
}
