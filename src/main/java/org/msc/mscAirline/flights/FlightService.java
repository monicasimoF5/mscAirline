package org.msc.mscAirline.flights;

import org.msc.mscAirline.airports.AirportRepository;

public class FlightService {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    public FlightService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }
}
