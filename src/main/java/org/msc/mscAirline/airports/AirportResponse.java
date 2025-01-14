package org.msc.mscAirline.airports;

public record AirportResponse(
        Long id,
        String name,
        String city,
        String country
) {
}
