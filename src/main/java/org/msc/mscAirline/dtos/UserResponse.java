package org.msc.mscAirline.dtos;

import org.msc.mscAirline.entities.User;

public record UserResponse(
        Long id,
        String name,
        String email,
        String password,
        String picture,
        User.Rol rol
) {
}
