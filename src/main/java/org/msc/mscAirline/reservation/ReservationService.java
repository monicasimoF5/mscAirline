package org.msc.mscAirline.reservation;

import org.msc.mscAirline.exceptions.AirlineNotFoundException;
import org.msc.mscAirline.flights.Flight;
import org.msc.mscAirline.flights.FlightRepository;
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

    public ReservationResponse createReservation(ReservationRequest reservationRequest){
        Optional<User> optionalUser = userRepository.findUserById(reservationRequest.userId());
        Optional<Flight> optionalFlight = flightRepository.findById(reservationRequest.flightId());

        if (optionalUser.isEmpty()) {
            throw new AirlineNotFoundException("There is no user with this id.");
        }

        if (optionalFlight.isEmpty()){
            throw new AirlineNotFoundException("There is no flight with this id.");
        }

        Flight flight = optionalFlight.get();
        if (reservationRequest.seats() > flight.getAvailableSeats()){
            throw new IllegalArgumentException("We're sorry, we don't have enough free seats for this flight.");
        }

        if (flight.getAvailableSeats() == 0){
            throw new IllegalArgumentException("There are no seats available for this flight.");
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

    public ReservationResponse findReservationById (Long id){
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if (optionalReservation.isEmpty()){
            throw new AirlineNotFoundException("The reservation " + id + " does not exist.");
        }

        Reservation reservation = optionalReservation.get();
        return ReservationMapper.toResponse(reservation);
    }

    public ReservationResponse updateReservation(Long reservationId, ReservationRequest reservationRequest){
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalReservation.isEmpty()){
            throw new AirlineNotFoundException("The reservation with id " + reservationId + " does not exist.");
        }

        Reservation reservation = optionalReservation.get();

        Optional<User> optionalUser = userRepository.findById(reservationRequest.userId());
        if (optionalUser.isEmpty()){
            throw new AirlineNotFoundException("User with id " + reservationRequest.userId() + " does not exist.");
        }

        Optional<Flight> optionalFlight = flightRepository.findById(reservationRequest.flightId());
        if(optionalFlight.isEmpty()){
            throw new AirlineNotFoundException("The Flight with the id" + reservationRequest.flightId() + "does not exist.");
        }

        reservation.setReservationTime(reservation.getReservationTime());
        reservation.setSeats(reservationRequest.seats());

        Reservation updateReservation = reservationRepository.save(reservation);

        return ReservationMapper.toResponse(updateReservation);

    }

    public void deleteReservation(){}



}
