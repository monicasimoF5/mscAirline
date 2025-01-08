package org.msc.mscAirline.dtos;

public record UserResponse(
        Long id,
        String name,
        String email,
        String password,
        String picture
) {
}
