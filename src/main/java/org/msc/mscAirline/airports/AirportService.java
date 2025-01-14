package org.msc.mscAirline.airports;

import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.msc.mscAirline.exceptions.AirlineNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<AirportResponse> findAll() {
        List<Airport> airportList = airportRepository.findAll();
        return airportList.stream()
                .map(AirportMapper::toResponse).toList();
    }

    public AirportResponse findById(Long id) {
        Optional<Airport> optionalAirport = airportRepository.findById(id);

        if (optionalAirport.isEmpty()){
            throw new AirlineNotFoundException("The Airport with id " + id + " does not exist.");
        }
        Airport airport = optionalAirport.get();
        return AirportMapper.toResponse(airport);
    }

    public List<AirportResponse> findByName(String name){
        Optional<Airport> airports = airportRepository.findByName(name);

        if (airports.isEmpty()){
            throw new AirlineNotFoundException("The airport with name " + name + " does not exist.");
        }
        return airports.stream()
                .map(AirportMapper::toResponse).toList();
    }


}
