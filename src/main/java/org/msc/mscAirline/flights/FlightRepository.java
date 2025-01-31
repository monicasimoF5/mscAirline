package org.msc.mscAirline.flights;

import org.msc.mscAirline.airports.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findFlightByName(String name);

    @Query(value = "SELECT f FROM Flight f " +
            "WHERE (:originCity IS NULL OR LOWER(f.origin.city) = LOWER(:originCity)) AND " +
            "(:destinationCity IS NULL OR LOWER(f.destination.city) = LOWER(:destinationCity)) AND " +
            "(:departureDate IS NULL OR CAST(f.departureTime AS date) = :departureDate) AND " +
            "f.availableSeats >= :availableSeats AND " +
            "f.statusFlight = true")
    List<Flight> findFlightsByCriteria(
            @Param("originCity") String originCity,
            @Param("destinationCity") String destinationCity,
            @Param("departureDate") LocalDate departureDate,
            @Param("availableSeats") Integer availableSeats);


    List<Flight> findByOriginAndDestinationAndDepartureTime(Airport origin, Airport destination, LocalDateTime departureTime);
}
