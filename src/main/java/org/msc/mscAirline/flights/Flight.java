package org.msc.mscAirline.flights;

import jakarta.persistence.*;
import lombok.*;
import org.msc.mscAirline.airports.Airport;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long fightId;
    private String flightName;
    private int availableSeats;
    private Date departureTime;
    private Date arrivalTime;

    @OneToOne
    @JoinColumn(name = "origin_id")
    Airport origin;

    @OneToOne
    @JoinColumn(name = "destination_id")
    Airport destination;

    public Flight(String flightName, Airport origin, Airport destination, int availableSeats, Date departureTime, Date arrivalTime) {
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight(Long fightId, String flightName, Airport origin, Airport destination, int availableSeats, Date departureTime, Date arrivalTime) {
        this.fightId = fightId;
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight() {
    }

    public Long getFightId() {
        return fightId;
    }

    public void setFightId(Long fightId) {
        this.fightId = fightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
