package com.example.online.reservation.system.mapper;

import com.example.online.reservation.system.dto.TicketRequestDto;
import com.example.online.reservation.system.dto.TicketResponseDto;
import com.example.online.reservation.system.entity.Ticket;

import java.util.List;

public class TicketMapper {
    public static TicketResponseDto entityToDto(Ticket ticketresponse) {
        return TicketResponseDto.builder()
                .price(ticketresponse.getPrice())
                .reservation(ReservationMapper.entityToDto(ticketresponse.getReservation()))
                .seatNumber(ticketresponse.getSeatNumber())
                .build();

    }

    public static Ticket dtoToEntity(TicketRequestDto ticketrequest) {
        return Ticket.builder()
                .reservation(ReservationMapper.dtoToEntity(ticketrequest.getReservation()))
                .price(ticketrequest.getPrice())
                .seatNumber(ticketrequest.getSeatNumber())
                .build();

    }

    public static List<TicketResponseDto> entityToList(List<Ticket> tickets) {
        return tickets.stream().map(TicketMapper::entityToDto).toList();

    }
}
