package org.msc.mscAirline.users;

import java.util.Optional;

import org.msc.mscAirline.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);

}
