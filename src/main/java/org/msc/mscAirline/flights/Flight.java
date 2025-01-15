package org.msc.mscAirline.flights;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.msc.mscAirline.airports.Airport;

import java.sql.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "origin_id")
    Airport origin;

    @OneToOne
    @JoinColumn(name = "destination_id")
    private Airport destination;

    private int availableSeats;
    private Date departureTime;
    private Date arrivalTime;

    public Flight(Airport origin, Airport destination, int availableSeats, Date departureTime, Date arrivalTime) {
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight(Long id, Airport origin, Airport destination, int availableSeats, Date departureTime, Date arrivalTime) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight(@NotNull(message = "The origin can not be null.") @NotEmpty(message = "The origin can not be empty.") Airport origin, @NotNull(message = "The destination can not be null.") @NotEmpty(message = "The destination can not be empty.") Airport destination, @NotNull(message = "The available seats can not be null.") int availableSeats, java.util.Date date, java.util.Date arrivalTime) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
