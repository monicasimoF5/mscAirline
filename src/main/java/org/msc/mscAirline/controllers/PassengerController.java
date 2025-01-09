package org.msc.mscAirline.controllers;

import jakarta.validation.Valid;
import org.msc.mscAirline.dtos.PassengerRequest;
import org.msc.mscAirline.dtos.PassengerResponse;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.msc.mscAirline.services.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
