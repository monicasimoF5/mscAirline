package org.msc.mscAirline.flights;

import jakarta.validation.Valid;
import org.msc.mscAirline.airports.Airport;
import org.msc.mscAirline.airports.AirportMapper;
import org.msc.mscAirline.airports.AirportRepository;
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

    public Flight createFlight(FlightRequest flightRequest){

        Optional<Airport> originAirport = airportRepository.findById(flightRequest.originId());
        if (!originAirport.isPresent()){
            throw new IllegalArgumentException("Origin airport not found.");
        }

        Optional<Airport> destinationAirport = airportRepository.findById(flightRequest.destinationId());
        if (!destinationAirport.isPresent()){
            throw new IllegalArgumentException("Destination airport not found.");
        }

        Flight flight = FlightMapper.toEntity(flightRequest, originAirport.get(), destinationAirport.get());
        return flightRepository.save(flight);
    }

    public FlightResponse findFlightById(Long flightId) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);

        if(optionalFlight.isEmpty()){
            throw new AirlineNotFoundException("The flight with flightId " + flightId + " does not exist.");
        }

        Flight flight = optionalFlight.get();
        return FlightMapper.toResponse(flight);
    }

    public List<FlightResponse> findFligthByName(String name){
        Optional<Flight> fligths = flightRepository.findFlightByName(name);

        if (fligths.isEmpty()){
            throw new AirlineNotFoundException("The flight with name " + name + " does not exist.");
        }
        return fligths.stream()
                .map(FlightMapper::toResponse).toList();
    }

    public FlightResponse updateFlightById(Long flightId, FlightRequest flightRequest) {
        Optional<Flight> existingFlight = flightRepository.findById(flightId);

        if (!existingFlight.isPresent()) {
            throw new AirlineNotFoundException("Flight with ID " + flightId + " not found.");
        }

        Flight flight = existingFlight.get();
        flight.setName(flightRequest.name());
        flight.setAvailableSeats(flightRequest.availableSeats());
        flight.setDepartureTime(flightRequest.departureTime());
        flight.setArrivalTime(flightRequest.arrivalTime());
        flightRepository.save(flight);

        return FlightMapper.toResponse(flight);
    }

    public void deleteFlightById (Long flightId) {
        Optional<Flight> existingFlight = flightRepository.findById(flightId);

        if (!existingFlight.isPresent()) {
            throw new AirlineNotFoundException("Flight with ID " + flightId + " not found.");
        }

        flightRepository.deleteById(flightId);

    }


}
