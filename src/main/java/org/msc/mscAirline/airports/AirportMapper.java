package org.msc.mscAirline.airports;

public class AirportMapper {
    public static Airport toEntity(AirportRequest airportRequest){
        return new Airport(
                airportRequest.name(),
                airportRequest.city(),
                airportRequest.country()
        );
    }

    public static Airport toResponse(Airport airport){
        return new AirportResponse(
                airport.getId(),
                airport.getName(),
                airport.getCity(),
                airport.getCountry()
        );
    }
}
