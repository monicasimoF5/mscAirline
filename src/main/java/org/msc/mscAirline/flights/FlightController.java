package org.msc.mscAirline.flights;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping()
    public ResponseEntity<List<FlightResponse>> getAllFlights(){
        List<FlightResponse> allFlights = flightService.listAllFlights();
        return new ResponseEntity<>(allFlights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getFlightById(@PathVariable Long id){
        FlightResponse flightResponse = flightService.findFlightById(id);
        return new ResponseEntity<>(flightResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightResponse> createFlight(@RequestBody @Valid FlightRequest flightRequest){
        FlightResponse flight = flightService.createFlight(flightRequest);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

}
