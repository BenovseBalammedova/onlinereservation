package com.example.online.reservation.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerNumberRecordResponseDto {

    private String pnrNumber;

    private UserResponseDto user;

    private LocalDateTime journeyDate;

    private LocalDateTime cancellationDate;

    private String status;

    private ReservationResponseDto reservation;

    private TrainResponseDto train;
}
