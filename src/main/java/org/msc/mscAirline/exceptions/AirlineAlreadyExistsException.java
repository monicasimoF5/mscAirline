package org.msc.mscAirline.exceptions;

public class AirlineAlreadyExistsException extends RuntimeException {
    public AirlineAlreadyExistsException(String message) {
        super(message);
    }
}
