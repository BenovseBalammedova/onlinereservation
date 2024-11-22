package com.example.online.reservation.system.service;

import com.example.online.reservation.system.dto.ReservationRequestDto;
import com.example.online.reservation.system.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {

    void create(ReservationRequestDto reservationRequestDto);

    ReservationResponseDto getById(Long id);

    void delete(Long id);

    List<ReservationResponseDto> getAll();

    List<ReservationResponseDto> findAllByTrainNumber(String trainNumber);

    List<ReservationResponseDto> findAllByFromLocation(String fromLocation);

    void update(Long id, ReservationRequestDto reservation);

    void updateToLocation(Long id, String toLocation);

    void updateFromLocation(Long id, String fromLocation);


}


