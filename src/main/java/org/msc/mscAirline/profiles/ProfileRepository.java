package org.msc.mscAirline.profiles;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
  Optional<Profile> existsByEmail(String email);

  Optional<Profile> findByEmail(@NotNull @NotEmpty @Email(message = "The email must be a correctly formatted address.") String email);

  List<Profile> findByEmailIgnoreCaseContaining(String email);
}