package org.msc.mscAirline.flights;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record FlightRequest(

        @NotNull(message = "The flight name can not be null.")
        @NotEmpty(message = "The flight name can not be empty.")
        String name,

        @NotNull(message = "The origin can not be null.")
        Long originId,

        @NotNull(message = "The destination can not be null.")
        Long destinationId,

        @NotNull(message = "The available seats can not be null.")
        int availableSeats,

        @Future(message = "The departure date must be before the arrival date.")
        @NotNull(message = "The departure time cannot be null.")
        LocalDateTime departureTime,

        @Future(message = "The arrival date must be before the departure date.")
        @NotNull(message = "The arrival time cannot be null.")
        LocalDateTime arrivalTime
){
}
