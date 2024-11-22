package com.example.online.reservation.system.repository;


import com.example.online.reservation.system.entity.PassengerNumberRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PassengerNumberRecordRepository extends JpaRepository<PassengerNumberRecord,Long> {

    List<PassengerNumberRecord> findAllByPnrNumber(String pnrNumber);

    List<PassengerNumberRecord> findAllByStatus(String status);
}
