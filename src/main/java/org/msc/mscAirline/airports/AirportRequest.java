package org.msc.mscAirline.airports;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AirportRequest(

        @NotNull(message = "The name cannot be null.")
        @NotEmpty(message = "The name cannot be empty.")
        String name,

        @NotNull(message = "The city cannot be null.")
        @NotEmpty(message = "The city cannot be empty.")
        String city,

        @NotNull(message = "The country cannot be null.")
        @NotEmpty(message = "The country cannot be empty.")
        String country
) {
}
