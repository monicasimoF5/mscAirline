package org.msc.mscAirline.reservation;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ReservationRequest(

        Date reservationTime,

        @NotNull(message = "The number of seats cannot be null.")
        int seats,

        @NotNull(message = "The field flight ID cannot be null.")
        Long flightId,

        @NotNull(message = "The field user ID cannot be null.")
        Long userId

) {
}
