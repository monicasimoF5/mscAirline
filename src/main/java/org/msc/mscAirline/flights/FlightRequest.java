package org.msc.mscAirline.flights;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.msc.mscAirline.airports.Airport;

import java.util.Date;

public record FlightRequest(

        @NotNull(message = "The origin can not be null.")
        @NotEmpty(message = "The origin can not be empty.")
        Airport origin,

        @NotNull(message = "The destination can not be null.")
        @NotEmpty(message = "The destination can not be empty.")
        Airport destination,

        @NotNull(message = "The available seats can not be null.")
        int availableSeats,

        Date departureTime,
        Date arrivalTime
){
}
