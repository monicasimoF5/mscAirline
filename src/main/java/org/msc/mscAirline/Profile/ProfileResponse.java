package org.msc.mscAirline.Profile;

public record ProfileResponse(
        Long id,
        String name,
        String email,
        String password,
        String picture,
        Profile.Rol rol
) {
}
