package org.msc.mscAirline.reservation;

import org.msc.mscAirline.flights.Flight;
import org.msc.mscAirline.flights.FlightMapper;
import org.msc.mscAirline.flights.FlightResponse;
import org.msc.mscAirline.users.User;
import org.msc.mscAirline.users.UserMapper;
import org.msc.mscAirline.users.UserResponse;

public class ReservationMapper {
    public static Reservation toEntity(ReservationRequest reservationRequest, Flight flight, User user) {
        return new Reservation(
                reservationRequest.reservationTime(),
                reservationRequest.seats(),
                flight,
                user
        );
    }

    public static ReservationResponse toResponse(Reservation reservation){
        FlightResponse flightResponse = FlightMapper.toResponse(reservation.getFlight());
        UserResponse userResponse = UserMapper.toResponse(reservation.getUser());
        return new ReservationResponse(
                reservation.getReservationId(),
                reservation.getReservationTime(),
                reservation.getSeats(),
                flightResponse,
                userResponse);
    }
}
