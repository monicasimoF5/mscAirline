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

    public AirportResponse findAirportById(Long airportId) {
        Optional<Airport> optionalAirport = airportRepository.findById(airportId);

        if (optionalAirport.isEmpty()){
            throw new AirlineNotFoundException("The Airport with id " + airportId + " does not exist.");
        }
        Airport airport = optionalAirport.get();
        return AirportMapper.toResponse(airport);
    }

    public List<AirportResponse> findAirportByName(String name){
        Optional<Airport> airports = airportRepository.findByName(name);

        if (airports.isEmpty()){
            throw new AirlineNotFoundException("The airport with name " + name + " does not exist.");
        }
        return airports.stream()
                .map(AirportMapper::toResponse).toList();
    }

    public AirportResponse updateAirportById(Long id, AirportRequest airportRequest){
        Optional<Airport> optionalAirport = airportRepository.findById(id);

        if (optionalAirport.isPresent()){
            Airport airport = optionalAirport.get();

            airport.setName(airportRequest.name());
            airport.setCity(airportRequest.city());
            airport.setCountry(airportRequest.country());

            Airport updateAirport = airportRepository.save(airport);
            return AirportMapper.toResponse(updateAirport);
        }
        throw new AirlineNotFoundException("The airport with id " + id + " does not exist.");
    }

    public void deleteAirportById(Long airportId){
        Optional<Airport> optionalAirport = airportRepository.findById(airportId);

        if (optionalAirport.isEmpty()){
            throw new AirlineNotFoundException("The airport with id " + airportId + " does not exist.");
        }
        airportRepository.deleteById(airportId);
    }

}
