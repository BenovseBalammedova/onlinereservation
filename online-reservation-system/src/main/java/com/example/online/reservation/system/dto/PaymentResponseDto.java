package com.example.online.reservation.system.dto;

import com.example.online.reservation.system.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponseDto {

    private LocalDateTime paymentDate;

    private double amount;

    private PaymentMethod paymentMethod;

    private ReservationResponseDto reservation;
}
