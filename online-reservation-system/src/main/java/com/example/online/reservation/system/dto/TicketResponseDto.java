package com.example.online.reservation.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TicketResponseDto {

    private String seatNumber;

    private double price;

    private ReservationResponseDto reservation;
}
