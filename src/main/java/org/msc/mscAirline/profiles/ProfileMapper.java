package org.msc.mscAirline.profiles;

import jakarta.validation.Valid;
import org.msc.mscAirline.users.User;

public class ProfileMapper {
    public static Profile toEntity(@Valid ProfileRequest profileRequest, User user){
        return new Profile(
                profileRequest.name(),
                profileRequest.phone(),
                profileRequest.email(),
                profileRequest.picture(),
                user
        );
    }

    public static ProfileResponse toResponse(Profile profile){
        return new ProfileResponse(
                profile.getProfileId(),
                profile.getName(),
                profile.getPhone(),
                profile.getEmail(),
                profile.getPicture(),
                profile.getUser().getId()
        );
    }

}
