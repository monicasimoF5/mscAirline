package org.msc.mscAirline.profiles;

import jakarta.validation.constraints.*;

public record ProfileRequest(

        @NotNull
        @NotEmpty
        String name,

        @NotBlank
        @Size(min = 9, max = 9, message = "The phone must be have 9 digits" )
        @Pattern(regexp = "^\\d{9}$", message = "The Phone must be have 9 digits")
        String phone,

        @NotNull
        @NotEmpty
        @Email(message = "The email must be a correctly formatted address.")
        String email,

        String picture,

        @NotNull(message = "The profile ID cannot be null")
        Long userId

) {

}
