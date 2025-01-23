package org.msc.mscAirline.exceptions;

import org.msc.mscAirline.flights.FlightValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

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

}
