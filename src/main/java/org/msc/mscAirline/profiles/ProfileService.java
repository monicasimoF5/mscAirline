package org.msc.mscAirline.profiles;

import jakarta.validation.Valid;
import org.msc.mscAirline.airports.Airport;
import org.msc.mscAirline.airports.AirportMapper;
import org.msc.mscAirline.exceptions.AirlineNotFoundException;
import org.msc.mscAirline.exceptions.AirlineAlreadyExistsException;
import org.msc.mscAirline.users.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Object createProfile(ProfileRequest profileRequest, User user) throws AirlineAlreadyExistsException {
        Optional<Profile> findProfile = profileRepository.findProfileByEmail(profileRequest.email());
        if (findProfile.isPresent())
            throw new AirlineAlreadyExistsException("Profile already exist with this email.");

        Profile profile = ProfileMapper.toEntity(profileRequest, user);
        Profile savedProfile = profileRepository.save(profile);
        return ProfileMapper.toResponse(savedProfile);
    }

    public List<ProfileResponse> findAll() {
        List<Profile> profileList = profileRepository.findAll();
        return profileList.stream()
                .map(ProfileMapper::toResponse).toList();
    }

    public List<ProfileResponse> getAllProfiles() {
        List<Profile> profileList = profileRepository.findAll();
        return profileList.stream()
                .map(ProfileMapper::toResponse).toList();
    }

    public ProfileResponse findProfileById(Long profileId) {
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);

        if (optionalProfile.isEmpty()) {
            throw new AirlineNotFoundException("The profile with id " + profileId + " does not exist.");
        }

        Profile profile = optionalProfile.get();
        return ProfileMapper.toResponse(profile);
    }

    public List<ProfileResponse> findProfileByEmail(String email) {
        Optional<Profile> profiles = profileRepository.findProfileByEmail(email);

        if (profiles.isEmpty()) {
            throw new AirlineNotFoundException("The profile with email " + email + " does not exist.");
        }
        return profiles.stream()
                .map(ProfileMapper::toResponse).toList();
    }

    public ProfileResponse updateProfileById(Long profileId, @Valid ProfileRequest profileRequest) {
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);

        if (optionalProfile.isEmpty()) {
            throw new AirlineNotFoundException("The profile with id " + profileId + " does not exist.");
        }

        Profile profile = optionalProfile.get();

        profile.setName(profileRequest.name());
        profile.setPhone(profileRequest.phone());
        profile.setEmail(profileRequest.email());
        profile.setPicture(profileRequest.picture());

        Profile updatedProfile = profileRepository.save(profile);
        return ProfileMapper.toResponse(updatedProfile);
    }

}

