package org.msc.mscAirline.mappers;

import jakarta.validation.Valid;
import org.msc.mscAirline.dtos.PassengerRequest;
import org.msc.mscAirline.dtos.PassengerResponse;
import org.msc.mscAirline.entities.Passenger;

public class PassengerMapper {
    public static Passenger toEntity(@Valid PassengerRequest passengerRequest){
        return new Passenger(
                passengerRequest.name(),
                passengerRequest.email(),
                passengerRequest.password(),
                passengerRequest.picture(),
                passengerRequest.rol()
        );
    }

    public static PassengerResponse toResponse(Passenger passenger){
        return new PassengerResponse(
                passenger.getId(),
                passenger.getName(),
                passenger.getEmail(),
                passenger.getPassword(),
                passenger.getPicture(),
                passenger.getRol()
        );
    }

}
