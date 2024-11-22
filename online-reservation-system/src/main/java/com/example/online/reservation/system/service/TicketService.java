package com.example.online.reservation.system.service;

import com.example.online.reservation.system.dto.TicketRequestDto;
import com.example.online.reservation.system.dto.TicketResponseDto;
import com.example.online.reservation.system.dto.TrainResponseDto;

import java.util.List;

public interface TicketService {

    void create(TicketRequestDto ticketRequestDto);

    TicketResponseDto getById(Long id);

    void delete(Long id);

    List<TicketResponseDto> getAll();

    List<TicketResponseDto> findAllBySeatNumber(String seatNumber);

    List<TicketResponseDto> findAllByPrice(double price);

    void updateSeatNumber(Long id, String seatNumber);

    void updatePrice(Long id, double price);
}
