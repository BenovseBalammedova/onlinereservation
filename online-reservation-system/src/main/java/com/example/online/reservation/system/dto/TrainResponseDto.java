package com.example.online.reservation.system.dto;


import com.example.online.reservation.system.enums.ClassType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainResponseDto {

    private String trainNumber;

    private String trainName;

    private ClassType classType;

    private int availableSeats;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private String fromLocation;

    private String toLocation;

   private List<ReservationResponseDto> reservations;

    private List<PassengerNumberRecordResponseDto> passengerNumberRecords;
}
