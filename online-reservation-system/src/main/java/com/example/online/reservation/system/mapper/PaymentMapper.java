package com.example.online.reservation.system.mapper;

import com.example.online.reservation.system.dto.PaymentRequestDto;
import com.example.online.reservation.system.dto.PaymentResponseDto;
import com.example.online.reservation.system.entity.Payment;

import java.util.List;


public class PaymentMapper {
    public static PaymentResponseDto entityToDto(Payment paymentresponse) {
        return PaymentResponseDto.builder()
                .paymentDate(paymentresponse.getPaymentDate())
                .paymentMethod(paymentresponse.getPaymentMethod())
                .amount(paymentresponse.getAmount())
                .reservation(ReservationMapper.entityToDto(paymentresponse.getReservation()))
                .build();

    }

    public static Payment dtoToEntity(PaymentRequestDto paymentrequest) {
        return Payment.builder()
                .amount(paymentrequest.getAmount())
                .paymentMethod(paymentrequest.getPaymentMethod())
                .cvv(paymentrequest.getCvv())
                .cardNumber(paymentrequest.getCardNumber())
                .paymentDate(paymentrequest.getPaymentDate())
                .build();
    }

    public static List<PaymentResponseDto> entityToList(List<Payment> paymentresponse) {
        return paymentresponse.stream().map(PaymentMapper::entityToDto).toList();
    }


}
