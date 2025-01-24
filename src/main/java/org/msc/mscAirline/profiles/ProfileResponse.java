package org.msc.mscAirline.profiles;

import org.msc.mscAirline.users.User;

public record ProfileResponse(
        Long id,
        String name,
        String phone,
        String email,
        String picture,
        Long userId
) {
}
