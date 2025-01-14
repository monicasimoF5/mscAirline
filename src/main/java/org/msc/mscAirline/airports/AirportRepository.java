package org.msc.mscAirline.airports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.msc.mscAirline.airports.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    Optional<Airport> findByName(String name);

    Optional<Airport> findById(Long id);
}
