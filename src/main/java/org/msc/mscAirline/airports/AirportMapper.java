package org.msc.mscAirline.airports;

public class AirportMapper {
    public static Airport toEntity(AirportRequest airportRequest){
        return new Airport(
                airportRequest.name(),
                airportRequest.city(),
                airportRequest.country()
        );
    }

    public static AirportResponse toResponse(Airport airport){
        return new AirportResponse(
                airport.getAirportId(),
                airport.getName(),
                airport.getCity(),
                airport.getCountry()
        );
    }
}
