package com.example.online.reservation.system.serviceImpl;

import com.example.online.reservation.system.dto.PaymentRequestDto;
import com.example.online.reservation.system.dto.PaymentResponseDto;
import com.example.online.reservation.system.entity.Payment;
import com.example.online.reservation.system.enums.PaymentMethod;
import com.example.online.reservation.system.mapper.PaymentMapper;
import com.example.online.reservation.system.repository.PaymentRepository;
import com.example.online.reservation.system.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void create(PaymentRequestDto paymentRequestDto) {
        Payment payment = PaymentMapper.dtoToEntity(paymentRequestDto);
        paymentRepository.save(payment);

    }

    @Override
    public PaymentResponseDto getById(Long id) {
        Payment payment = paymentRepository.findById(id).get();
        return PaymentMapper.entityToDto(payment);
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<PaymentResponseDto> getAll() {
        List<Payment> payments = paymentRepository.findAll();
        return PaymentMapper.entityToList(payments);
    }

    @Override
    public List<PaymentResponseDto> findAllByPaymentDate(LocalDateTime paymentDate) {
        List<Payment> payments = paymentRepository.findAllByPaymentDate(paymentDate);
        return PaymentMapper.entityToList(payments);
    }

    @Override
    public List<PaymentResponseDto> findAllByAmount(double amount) {
        List<Payment> payments = paymentRepository.findAllByAmount(amount);
        return PaymentMapper.entityToList(payments);
    }

    @Override
    public void update(Long id, PaymentRequestDto paymentRequestDto) {
        Payment payment = paymentRepository.findById(id).get();
        payment.setPaymentDate(paymentRequestDto.getPaymentDate());
        payment.setPaymentMethod(paymentRequestDto.getPaymentMethod());
        payment.setCvv(paymentRequestDto.getCvv());
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setCardNumber(paymentRequestDto.getCardNumber());
        paymentRepository.save(payment);
    }

    @Override
    public void updateAmount(Long id, double amount) {
        Payment payment = paymentRepository.findById(id).get();
        payment.setAmount(amount);
        paymentRepository.save(payment);


    }

    @Override
    public void updatePaymentMethod(Long id, PaymentMethod paymentMethod) {
        Payment payment = paymentRepository.findById(id).get();
        payment.setPaymentMethod(paymentMethod);
        paymentRepository.save(payment);

    }
}
