package org.msc.mscAirline.airports;

public record AirportResponse(
        Long airportId,
        String name,
        String city,
        String country
) {
}
