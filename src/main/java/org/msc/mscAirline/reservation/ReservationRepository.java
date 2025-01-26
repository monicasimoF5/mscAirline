package org.msc.mscAirline.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository <Reservation, Long>{

}
