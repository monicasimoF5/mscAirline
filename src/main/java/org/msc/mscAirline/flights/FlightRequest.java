package org.msc.mscAirline.flights;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record FlightRequest(

        @NotNull(message = "The flight name can not be null.")
        @NotEmpty(message = "The flight name can not be empty.")
        String flightName,

        @NotNull(message = "The origin can not be null.")
        Long originId,

        @NotNull(message = "The destination can not be null.")
        Long destinationId,

        @NotNull(message = "The available seats can not be null.")
        int availableSeats,

        Date departureTime,
        Date arrivalTime
){
}
