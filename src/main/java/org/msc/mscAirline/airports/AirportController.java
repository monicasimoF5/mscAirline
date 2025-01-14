package org.msc.mscAirline.airports;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airports")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public ResponseEntity<AirportResponse> createAirport(@RequestBody @Valid AirportRequest airportRequest){
        AirportResponse airportResponse = airportService.createAirport(airportRequest);
        return new ResponseEntity<>(airportResponse, HttpStatus.CREATED);
    }
}
