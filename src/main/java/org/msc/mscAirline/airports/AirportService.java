package org.msc.mscAirline.airports;

import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;


    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public AirportResponse createAirport(AirportRequest airportRequest){
        Optional<Airport> existAirport = airportRepository.findByName(airportRequest.name());
        if (existAirport.isPresent())
            throw new AirlineAlreadyExistsException("Airport already exist with this name.");

        Airport airport = AirportMapper.toEntity(airportRequest);
        Airport savedAirport = airportRepository.save(airport);
        return AirportMapper.toResponse(savedAirport);
    }



}
