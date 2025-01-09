package org.msc.mscAirline.controllers;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.msc.mscAirline.dtos.PassengerRequest;
import org.msc.mscAirline.dtos.PassengerResponse;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.msc.mscAirline.services.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<PassengerResponse> createPassenger(@RequestBody @Valid PassengerRequest passengerRequest) throws AirlineAlreadyExistsException {
        PassengerResponse user = (PassengerResponse) passengerService.createPassenger(passengerRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerResponse> getPassengerById(@PathVariable Long id){
        PassengerResponse passengerResponse = passengerService.findById(id);
        return new ResponseEntity<>(passengerResponse, HttpStatus.OK);
    }

    @GetMapping
    public List<PassengerResponse> getPassengerByEmail(@PathParam("email") String email){
        if (email == null){
            return passengerService.findAll();
        }
        return passengerService.findByEmailIgnoreCaseContaining(email);
    }

}
