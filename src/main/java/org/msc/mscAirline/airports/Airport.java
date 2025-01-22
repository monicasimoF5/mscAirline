package org.msc.mscAirline.airports;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long airportId;
    private String name;
    private String city;
    private String country;

    public Airport() {
    }

    public Airport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Airport(
            long airportId,

            @NotNull(message = "The name cannot be null.")
            @NotEmpty(message = "The name cannot be empty.")
            String name,

            @NotNull(message = "The city cannot be null.")
            @NotEmpty(message = "The city cannot be empty.")
            String city,

            @NotNull(message = "The country cannot be null.")
            @NotEmpty(message = "The country cannot be empty.")
            String country) {
        this.airportId = airportId;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
