package com.example.online.reservation.system.service;

import com.example.online.reservation.system.dto.*;
import java.time.LocalDateTime;
import java.util.List;

public interface PassengerNumberRecordService {

    void create(PassengerNumberRecordRequestDto psnRequestDto);

    PassengerNumberRecordResponseDto getById(Long id);

    void delete(Long id);

    List<PassengerNumberRecordResponseDto> getAll();

    List<PassengerNumberRecordResponseDto> findAllByPnrNumber(String pnrNumber);

    List<PassengerNumberRecordResponseDto> findAllByStatus(String status);

    void update(Long id, PassengerNumberRecordRequestDto pnr);

    void updateJourneyDate(Long id, LocalDateTime journeyDate);

    void updatePnrNumber(Long id, String pnrNumber);

}
