package org.msc.mscAirline.services;

import jakarta.validation.Valid;
import org.msc.mscAirline.dtos.PassengerRequest;
import org.msc.mscAirline.dtos.PassengerResponse;
import org.msc.mscAirline.entities.Passenger;
import org.msc.mscAirline.exceptions.AirlineNotFoundException;
import org.msc.mscAirline.mappers.PassengerMapper;
import org.msc.mscAirline.repositories.PassengerRepository;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Object createPassenger(PassengerRequest passengerRequest) throws AirlineAlreadyExistsException {
        Optional<Passenger> findPassenger = passengerRepository.findByEmail(passengerRequest.email());
        if (findPassenger.isPresent())
            throw new AirlineAlreadyExistsException("Passenger already exist with this email.");

        Passenger passenger = PassengerMapper.toEntity(passengerRequest);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return PassengerMapper.toResponse(savedPassenger);
    }

    public PassengerResponse findById(Long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);

        if (optionalPassenger.isEmpty()){
            throw new AirlineNotFoundException("The passenger with id " + id + " does not exist.");
        }

        Passenger passenger = optionalPassenger.get();
        return PassengerMapper.toResponse(passenger);
    }


}
