package org.msc.mscAirline.dtos;

import org.msc.mscAirline.entities.Passenger;

public record PassengerResponse(
        Long id,
        String name,
        String email,
        String password,
        String picture,
        Passenger.Rol rol
) {
}
