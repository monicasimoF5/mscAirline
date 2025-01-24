package org.msc.mscAirline.profiles;

public record ProfileResponse(
        Long profileId,
        String name,
        String phone,
        String email,
        String picture,
        Long userId
) {
}
