package org.msc.mscAirline.airports;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<AirportResponse>> getAllAirports(){
        List<AirportResponse> allAirports = airportService.findAll();
        return new ResponseEntity<>(allAirports, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public List<AirportResponse> getAirportByIdOrName(@PathVariable String name){
        try{
            Long id = Long.parseLong(name);
            return Collections.singletonList(airportService.findById(id));
        } catch (NumberFormatException e) {
            return airportService.findByName(name);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportResponse> updateAirport(@PathVariable Long id, @RequestBody @Valid AirportRequest airportRequest){
        AirportResponse airportResponse = airportService.updateAirportById(id, airportRequest);
        return new ResponseEntity<>(airportResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long id){
        airportService.deleteAirportById(id);
        return new ResponseEntity<>("The airport has been eliminated", HttpStatus.OK);
    }

}
