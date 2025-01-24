package org.msc.mscAirline.reservation;

import org.msc.mscAirline.flights.FlightResponse;
import org.msc.mscAirline.users.UserResponse;

import java.util.Date;

public record ReservationResponse(
        Long reservationId,
        Date reservationTime,
        int seats,
        FlightResponse flight,
        UserResponse user

) {
}
