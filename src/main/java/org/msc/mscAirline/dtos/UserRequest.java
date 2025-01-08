package org.msc.mscAirline.dtos;

import jakarta.validation.constraints.*;
import org.msc.mscAirline.entities.User;

public record UserRequest (

        @NotNull
        @NotEmpty
        String name,

        @NotNull
        @NotEmpty
        @Email(message = "The email must be a correctly formatted address.")
        String email,

        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*]{4,8}$", message = "The password must be at least 4 and at most 8 characters long. It must contain at least one number, one uppercase letter, and one special character.")
        String password,

        String picture,

        User.Rol rol
) {
}
