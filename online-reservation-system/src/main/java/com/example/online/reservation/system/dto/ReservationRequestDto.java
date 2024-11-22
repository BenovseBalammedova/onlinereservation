package com.example.online.reservation.system.dto;

import com.example.online.reservation.system.enums.ClassType;
import com.example.online.reservation.system.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationRequestDto {

    private String trainNumber;

    private String trainName;

    private LocalDate journeyDate;

    private String fromLocation;

    private String toLocation;

    private double picketPrice;

    private ClassType classType;

    private ReservationStatus reservationStatus;

}
