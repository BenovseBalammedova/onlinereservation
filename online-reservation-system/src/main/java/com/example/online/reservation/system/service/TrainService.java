package com.example.online.reservation.system.service;

import com.example.online.reservation.system.dto.*;


import java.time.LocalDateTime;
import java.util.List;

public interface TrainService {

    void create(TrainRequestDto trainRequestDto);

    TrainResponseDto getById(Long id);

    void delete(Long id);

    List<TrainResponseDto> getAll();

    List<TrainResponseDto> findAllByTrainNumber(String trainNumber);

    List<TrainResponseDto> findAllByTrainName(String name);

    void update(Long id, TrainRequestDto trainRequestDto);

    void updateDepartureTime(Long id, LocalDateTime departureTime);

    void updateTrainName(Long id, String trainName);


}

