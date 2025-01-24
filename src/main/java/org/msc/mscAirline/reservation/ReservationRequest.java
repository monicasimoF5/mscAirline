package org.msc.mscAirline.reservation;

import jakarta.validation.constraints.Future;
import org.msc.mscAirline.flights.Flight;
import org.msc.mscAirline.users.User;

import java.util.Date;

public record ReservationRequest(

        Date reservationTime,

        int seats,

        Long flightId,

        Long userId

) {
}
