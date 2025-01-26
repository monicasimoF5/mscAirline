package org.msc.mscAirline.reservation;

import java.util.Date;

public record ReservationRequest(

        Date reservationTime,

        int seats,

        Long flightId,

        Long userId

) {
}
