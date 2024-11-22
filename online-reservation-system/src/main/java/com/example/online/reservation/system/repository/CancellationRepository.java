package com.example.online.reservation.system.repository;


import com.example.online.reservation.system.entity.Cancellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CancellationRepository extends JpaRepository<Cancellation,Long> {

    List<Cancellation> findAllByPnrNumber(String pnrNumber);

    List<Cancellation> findAllByCancellationDate(LocalDate cancellationDate);
}
