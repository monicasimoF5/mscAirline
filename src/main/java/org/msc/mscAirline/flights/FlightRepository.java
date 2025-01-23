package org.msc.mscAirline.flights;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    /*Optional<Flight> findByFlightNameAndDestinationAirportId(String flightName, Long destinationId);*/

    Optional<Flight> findFlightByName(String name);
}
