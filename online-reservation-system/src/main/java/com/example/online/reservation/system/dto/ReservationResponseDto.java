package com.example.online.reservation.system.dto;

import com.example.online.reservation.system.enums.ClassType;
import com.example.online.reservation.system.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponseDto {

    private String trainNumber;

    private String trainName;

    private LocalDate journeyDate;

    private String fromLocation;

    private String toLocation;

    private double picketPrice;

    private LocalDateTime cancelledAt;

    private ClassType classType;

    private ReservationStatus reservationStatus;

    private UserResponseDto user;

    private TrainResponseDto trainresponsedto;

    private PaymentResponseDto payment;

    private CancellationResponseDto cancellation;

    private PassengerNumberRecordResponseDto passengerNumberRecord;

}
