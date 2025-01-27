package org.msc.mscAirline.flights;

import org.msc.mscAirline.airports.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findFlightByName(String name);

    @Query(value = "SELECT f FROM Flight f " +
            "WHERE (f.origin.id = :originAirportId OR :originAirportId IS NULL) AND " +
            "(f.destination.id = :destinationAirportId OR :destinationAirportId IS NULL) AND " +
            "f.departureTime = :departureTime AND " +
            "f.availableSeats >= :availableSeats AND " +
            "f.statusFlight = true")

    List<Flight> findFlightsByCriteria(
            @Param("originAirportId") Long originAirportId,
            @Param("destinationAirportId") Long destinationAirportId,
            @Param("departureTime") LocalDateTime departureTime,
            @Param("availableSeats") int minAvailableSeats);

    List<Flight> findByOriginAndDestinationAndDepartureTime(Airport origin, Airport destination, LocalDateTime departureTime);
}
