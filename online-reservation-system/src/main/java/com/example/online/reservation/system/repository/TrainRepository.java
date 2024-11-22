package com.example.online.reservation.system.repository;

import com.example.online.reservation.system.dto.TrainResponseDto;
import com.example.online.reservation.system.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrainRepository extends JpaRepository<Train,Long> {
    List<Train> findAllByTrainNumber(String trainNumber);
    List<Train> findAllByTrainName(String name);

}
