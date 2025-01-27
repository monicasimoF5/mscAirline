package org.msc.mscAirline.flights;

import jakarta.validation.Valid;
import org.msc.mscAirline.airports.AirportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService flightService;
    private final AirportRepository airportRepository;

    public FlightController(FlightService flightService, AirportRepository airportRepository) {
        this.flightService = flightService;
        this.airportRepository = airportRepository;
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody @Valid FlightRequest flightRequest){
        Flight flight = flightService.createFlight(flightRequest);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<FlightResponse>> getAllFlights(){
        List<FlightResponse> allFlights = flightService.listAllFlights();
        return new ResponseEntity<>(allFlights, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public List<FlightResponse> getFlightByIdOrName(@PathVariable String name){
        try{
            Long id = Long.parseLong(name);
            return Collections.singletonList(flightService.findFlightById(id));
        } catch (NumberFormatException exception) {
            return flightService.findFligthByName(name);
        }
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<FlightResponse> updateFlight(@PathVariable Long flightId, @RequestBody @Valid FlightRequest flightRequest){
        FlightResponse flightResponse = flightService.updateFlightById(flightId, flightRequest);
        return new ResponseEntity<>(flightResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<String> deleteFlight (@PathVariable Long flightId){
        flightService.deleteFlightById(flightId);
        return new ResponseEntity<>("The flight has been eliminated.", HttpStatus.OK);
    }

}

