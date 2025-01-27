package org.msc.mscAirline.flights;

import jakarta.validation.Valid;
import org.msc.mscAirline.airports.Airport;
import org.msc.mscAirline.airports.AirportRepository;
import org.msc.mscAirline.exceptions.AirlineNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    private void validateFlight(@Valid Flight flight) {

        if (flight.getArrivalTime().isBefore(flight.getDepartureTime())) {
            throw new FlightValidationException("Arrival time cannot be before departure time.");
        }

        long duration = ChronoUnit.HOURS.between(flight.getDepartureTime(), flight.getArrivalTime());
        if (duration > 12) {
            throw new FlightValidationException("Flight duration cannot exceed 12 hours.");
        }

        flight.setStatusFlight(flight.getAvailableSeats() > 0 && LocalDateTime.now().isBefore(flight.getDepartureTime()));

        if (flight.getAvailableSeats() <= 0 || LocalDateTime.now().isAfter(flight.getDepartureTime())) {
            flight.setStatusFlight(false); // Cambiar el estado a false si no hay plazas o está fuera de fecha
        }

        if (flight.getOrigin() == null || flight.getDestination() == null) {
            throw new FlightValidationException("Both origin and destination airports must be provided.");
        }

        if (flight.getOrigin().getAirportId().equals(flight.getDestination().getAirportId())) {
            throw new FlightValidationException("Origin and destination airports cannot be the same.");
        }

        Optional<Airport> originAirport = airportRepository.findById(flight.getOrigin().getAirportId());
        if (originAirport.isEmpty()) {
            throw new FlightValidationException("Origin airport with ID " + flight.getOrigin().getAirportId() + " does not exist.");
        }

        Optional<Airport> destinationAirport = airportRepository.findById(flight.getDestination().getAirportId());
        if (destinationAirport.isEmpty()) {
            throw new FlightValidationException("Destination airport with ID " + flight.getDestination().getAirportId() + " does not exist.");
        }
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

    public Flight createFlight(@Valid FlightRequest flightRequest){

        Flight flight = FlightMapper.toEntity(flightRequest,
                airportRepository.findById(flightRequest.originId()).orElse(null),
                airportRepository.findById(flightRequest.destinationId()).orElse(null));
        validateFlight(flight);
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

    public FlightResponse updateFlightById(@Valid Long flightId, FlightRequest flightRequest) {
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

        validateFlight(flight);

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
