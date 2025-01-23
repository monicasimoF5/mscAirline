package org.msc.mscAirline.flights;

public class FlightValidationException extends RuntimeException {
    public FlightValidationException(String message) {
        super(message);
    }
}
