package org.msc.mscAirline.users;

import java.util.List;
import java.util.Optional;

import org.msc.mscAirline.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findUserByUsername(String username);

    Optional<User> findUserById(Long id);
}
