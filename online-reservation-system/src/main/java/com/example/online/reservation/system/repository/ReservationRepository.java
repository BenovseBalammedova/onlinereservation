package com.example.online.reservation.system.repository;

import com.example.online.reservation.system.dto.ReservationResponseDto;
import com.example.online.reservation.system.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findAllByTrainNumber(String trainNumber);

    List<Reservation> findAllByFromLocation(String fromLocation);
}
