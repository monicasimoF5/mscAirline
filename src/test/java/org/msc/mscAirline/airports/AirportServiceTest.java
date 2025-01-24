package org.msc.mscAirline.airports;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ActiveProfiles("test")
@Sql(scripts = "/sql/cleanup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/sql/data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportService airportService;

    @Test
    public void testCreateAirport_Success() throws AirlineAlreadyExistsException {

        AirportRequest airportRequest = new AirportRequest("Barajas", "Madrid", "Spain");

        when(airportRepository.findByName(airportRequest.name())).thenReturn(Optional.empty());
        Airport savedAirport = new Airport(1L, airportRequest.name(), airportRequest.city(), airportRequest.country());
        when(airportRepository.save(any(Airport.class))).thenReturn(savedAirport);

        AirportResponse response = airportService.createAirport(airportRequest);

        assertEquals(response.name(), airportRequest.name());
        assertEquals(response.city(), airportRequest.city());
        assertEquals(response.country(), airportRequest.country());
    }

    @Test
    public void testFindAllAirports() {

        List<Airport> airports = Arrays.asList(new Airport(1L, "Barajas", "Madrid", "Spain"),
                new Airport(2L, "El Prat", "Barcelona", "Spain"));
        when(airportRepository.findAll()).thenReturn(airports);


        List<AirportResponse> responses = airportService.findAll();


        assertEquals(responses.size(), airports.size());
        assertEquals(responses.get(0).name(), airports.get(0).getName());
    }

    @Test
    public void testFindAirportById_Success() {

        Long airportId = 1L;
        Airport airport = new Airport(airportId, "Barajas", "Madrid", "Spain");
        when(airportRepository.findById(airportId)).thenReturn(Optional.of(airport));

        AirportResponse response = airportService.findAirportById(airportId);

        assertEquals(response.airportId(), airport.getAirportId());
        assertEquals(response.name(), airport.getName());
    }

    @Test
    public void testFindAirportByName_Success() {

        String airportName = "Barajas";
        Airport airport = new Airport(1L, airportName, "Madrid", "Spain");
        when(airportRepository.findByName(airportName)).thenReturn(Optional.of(airport));

        List<AirportResponse> responses = airportService.findAirportByName(airportName);

        assertEquals(responses.size(), 1);
        assertEquals(responses.get(0).name(), airportName);
    }

}