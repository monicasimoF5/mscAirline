package org.msc.mscAirline.flights;

import org.msc.mscAirline.airports.Airport;
import org.msc.mscAirline.airports.AirportRepository;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.msc.mscAirline.exceptions.AirlineNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    public FlightService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    public List<FlightResponse> listAllFlights() {
        List<Flight> flightList = flightRepository.findAll();
        List<FlightResponse> responseList = new ArrayList<>(Collections.emptyList());
        flightList.forEach(flight -> {
            FlightResponse flightResponse = FlightMapper.toResponse(flight);
            responseList.add(flightResponse);
        });

        if (flightList.isEmpty()){
            throw new AirlineNotFoundException("There are no scheduled flights.");
        }
        return responseList;
    }

    public FlightResponse createFlight(FlightRequest flightRequest){
        Optional<Flight> existFlight = flightRepository.findByFlightNameAndDestinationAirportId(flightRequest.flightName(), flightRequest.destinationId());
        if (existFlight.isPresent()){
            throw new AirlineAlreadyExistsException("The flight " + flightRequest.flightName() + " with destination " + flightRequest.destinationId() + " already exits.");
        }

        Optional<Airport> originAirport = airportRepository.findById(flightRequest.originId());
        if (originAirport.isEmpty()){
            throw new AirlineNotFoundException("Origin airport not found.");
        }

        Optional<Airport> destinationAirport = airportRepository.findById(flightRequest.destinationId());
        if (destinationAirport.isEmpty()){
            throw new AirlineNotFoundException("Destination airport not found.");
        }

        Airport origin = originAirport.get();
        Airport destination = destinationAirport.get();
        Flight flightToSave = FlightMapper.toEntity(flightRequest, origin, destination);
        Flight savedFlight = flightRepository.save(flightToSave);
        return FlightMapper.toResponse(savedFlight);
    }

    public FlightResponse findFlightById(Long id) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);

        if(optionalFlight.isEmpty()){
            throw new AirlineNotFoundException("The flight with id " + id + " does not exist.");
        }

        Flight flight = optionalFlight.get();
        return FlightMapper.toResponse(flight);
    }
}
