package org.msc.mscAirline.repositories;

import org.msc.mscAirline.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> existsByEmail(String email);
}