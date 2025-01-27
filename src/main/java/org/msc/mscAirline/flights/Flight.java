package org.msc.mscAirline.flights;

import jakarta.persistence.*;
import lombok.*;
import org.msc.mscAirline.airports.Airport;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long flightId;
    private String name;
    private int availableSeats;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    Airport origin;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    Airport destination;

    private boolean statusFlight;

    public Flight(String name, Airport origin, Airport destination, int availableSeats, LocalDateTime departureTime, LocalDateTime arrivalTime, boolean statusFlight) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.statusFlight = statusFlight;
    }

    public Flight() {
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isStatusFlight() {
        return statusFlight;
    }

    public void setStatusFlight(boolean statusFlight) {
        this.statusFlight = statusFlight;
    }

    public void reserveSeats(int seats) {

        if (seats <= 0 || seats > this.availableSeats) {
            throw new IllegalArgumentException("Insufficient number of seats to reserve.");
        }

        if (this.availableSeats != 0) {
            this.statusFlight = true;
        }

        this.availableSeats -= seats;
    }
}
