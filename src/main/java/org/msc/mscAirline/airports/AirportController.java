package org.msc.mscAirline.airports;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
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
            Long airportId = Long.parseLong(name);
            return Collections.singletonList(airportService.findAirportById(airportId));
        } catch (NumberFormatException e) {
            return airportService.findAirportByName(name);
        }
    }

    @PutMapping("/{airportId}")
    public ResponseEntity<AirportResponse> updateAirport(@PathVariable Long airportId, @RequestBody @Valid AirportRequest airportRequest){
        AirportResponse airportResponse = airportService.updateAirportById(airportId, airportRequest);
        return new ResponseEntity<>(airportResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long id){
        airportService.deleteAirportById(id);
        return new ResponseEntity<>("The airport has been eliminated", HttpStatus.OK);
    }

}
