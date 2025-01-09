package org.msc.mscAirline.repositories;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.msc.mscAirline.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
  Optional<Passenger> existsByEmail(String email);

  Optional<Passenger> findByEmail(@NotNull @NotEmpty @Email(message = "The email must be a correctly formatted address.") String email);

  List<Passenger> findByEmailIgnoreCaseContaining(String email);
}