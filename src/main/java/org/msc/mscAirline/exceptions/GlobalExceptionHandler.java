package org.msc.mscAirline.exceptions;

import org.msc.mscAirline.airports.AirportValidationException;
import org.msc.mscAirline.flights.FlightValidationException;
import org.msc.mscAirline.profiles.ProfileValidationExcepcion;
import org.msc.mscAirline.reservation.ReservationValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AirlineAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleVeterinaryAlreadyExistsException(AirlineAlreadyExistsException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AirlineNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(AirlineNotFoundException exception){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FlightValidationException.class)
    public ResponseEntity<Map<String, String>> handleFlightValidationException(FlightValidationException exception){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ReservationValidationException.class)
    public ResponseEntity<Map<String, String>> handleReservationValidationException(ReservationValidationException exception){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AirportValidationException.class)
    public ResponseEntity<Map<String, String>> handleAirportValidationException(AirportValidationException exception){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProfileValidationExcepcion.class)
    public ResponseEntity<Map<String, String>> handleProfileValidationException(ProfileValidationExcepcion exception){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }


}
