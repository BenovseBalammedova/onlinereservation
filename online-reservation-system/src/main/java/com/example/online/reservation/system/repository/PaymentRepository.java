package com.example.online.reservation.system.repository;

import com.example.online.reservation.system.dto.PaymentResponseDto;
import com.example.online.reservation.system.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    List<Payment> findAllByPaymentDate(LocalDateTime paymentDate);

    List<Payment> findAllByAmount(double amount);
}
