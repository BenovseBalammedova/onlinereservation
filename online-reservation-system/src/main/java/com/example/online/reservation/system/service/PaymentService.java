package com.example.online.reservation.system.service;

import com.example.online.reservation.system.dto.*;
import com.example.online.reservation.system.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentService {

    void create(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto getById(Long id);

    void delete(Long id);

    List<PaymentResponseDto> getAll();

    List<PaymentResponseDto> findAllByPaymentDate(LocalDateTime paymentDate);

    List<PaymentResponseDto> findAllByAmount(double amount);

    void update(Long id, PaymentRequestDto paymentRequestDto);

    void updateAmount(Long id, double amount);

    void updatePaymentMethod(Long id, PaymentMethod paymentMethod);


}
