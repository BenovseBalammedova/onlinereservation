package com.example.online.reservation.system.service;

import com.example.online.reservation.system.dto.CancellationRequestDto;
import com.example.online.reservation.system.dto.CancellationResponseDto;
import com.example.online.reservation.system.enums.CancellationStatus;

import java.time.LocalDate;
import java.util.List;

public interface CancellationService {

    void create(CancellationRequestDto cancellationRequestDto);

    CancellationResponseDto getById(Long id);

    void delete(Long id);

    List<CancellationResponseDto> getAll();

    List<CancellationResponseDto> findAllByPnrNumber(String pnrNumber);

    List<CancellationResponseDto> findAllByCancellationDate(LocalDate cancellationDate);

    void update(Long id, CancellationRequestDto cancellationRequestDto);

    void updatePnrNumber(Long id, String pnrNumber);

    void updateStatus(Long id, CancellationStatus status);


}
