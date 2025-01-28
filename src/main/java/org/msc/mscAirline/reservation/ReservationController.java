package org.msc.mscAirline.reservation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationService reservationService,
                                 ReservationRepository reservationRepository) {
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody @Valid ReservationRequest reservationRequest){
        ReservationResponse reservationResponse = reservationService.createReservation(reservationRequest);
        return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getAllReservations(){
        List<ReservationResponse> reservationResponseList = reservationService.findAllReservations();
        return new ResponseEntity<>(reservationResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> getReservationById(@PathVariable @Valid Long id){
        ReservationResponse reservationResponse = reservationService.findReservationById(id);
        return new ResponseEntity<>(reservationResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponse> updateReservation(@RequestParam Long reservationId, @RequestBody @Valid ReservationRequest reservationRequest){
        ReservationResponse reservationResponse = reservationService.updateReservation(reservationId, reservationRequest);
        return new ResponseEntity<>(reservationResponse, HttpStatus.OK);
    }


}
