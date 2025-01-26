package org.msc.mscAirline.reservation;

import jakarta.validation.Valid;
import org.msc.mscAirline.exceptions.AirlineNotFoundException;
import org.msc.mscAirline.flights.Flight;
import org.msc.mscAirline.flights.FlightRepository;
import org.msc.mscAirline.flights.FlightService;
import org.msc.mscAirline.register.RegisterService;
import org.msc.mscAirline.users.User;
import org.msc.mscAirline.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, FlightRepository flightRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
    }

    private void validateReservation(Reservation reservation){

    }

    public ReservationResponse createReservation(@Valid ReservationRequest reservationRequest) throws Exception {
        Optional<User> optionalUser = userRepository.findUserById(reservationRequest.userId());
        Optional<Flight> optionalFlight = flightRepository.findById(reservationRequest.flightId());

        if (!optionalUser.isPresent()) {
            throw new AirlineNotFoundException("There is no user with this id.");
        }

        if (!optionalFlight.isPresent()){
            throw new AirlineNotFoundException("There is no flight with this id.");
        }

        Flight flight = optionalFlight.get();
        if (reservationRequest.seats() > flight.getAvailableSeats()){
            throw new IllegalArgumentException("We are sorry, we do not have enough seats for this flight.");
        }

        Reservation reservation = ReservationMapper.toEntity(reservationRequest, optionalFlight.get(), optionalUser.get());
        Reservation savedReservation = reservationRepository.save(reservation);

        flight.reserveSeats(reservationRequest.seats());
        flightRepository.save(flight);

        return ReservationMapper.toResponse(savedReservation);

    }

    public List<ReservationResponse> findAllReservations(){
        List<Reservation> reservationList = reservationRepository.findAll();
        List<ReservationResponse> reservationResponseList = new ArrayList<>(Collections.emptyList());

        reservationList.forEach(reservation -> {
            ReservationResponse reservationResponse = ReservationMapper.toResponse(reservation);
            reservationResponseList.add(reservationResponse);
        });

        if (reservationList.isEmpty()){
            throw new AirlineNotFoundException("There is not reservation to show.");
        }

        return reservationResponseList;
    }


}
