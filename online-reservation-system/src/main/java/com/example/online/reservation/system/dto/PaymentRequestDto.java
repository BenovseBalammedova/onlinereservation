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
public class PaymentRequestDto {

    private String cardNumber;

    private LocalDateTime paymentDate;

    private String cvv;

    private double amount;

    private PaymentMethod paymentMethod;


}
