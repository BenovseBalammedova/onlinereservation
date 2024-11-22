package com.example.online.reservation.system.serviceImpl;

import com.example.online.reservation.system.dto.TicketRequestDto;
import com.example.online.reservation.system.dto.TicketResponseDto;
import com.example.online.reservation.system.entity.Ticket;
import com.example.online.reservation.system.mapper.TicketMapper;
import com.example.online.reservation.system.repository.TicketRepository;
import com.example.online.reservation.system.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketrepository;

    public TicketServiceImpl(TicketRepository ticketrepository) {
        this.ticketrepository = ticketrepository;
    }

    @Override
    public void create(TicketRequestDto ticketRequestDto) {
        Ticket ticket = TicketMapper.dtoToEntity(ticketRequestDto);
        ticketrepository.save(ticket);

    }

    @Override
    public TicketResponseDto getById(Long id) {
        Ticket ticket = ticketrepository.findById(id).get();
        return TicketMapper.entityToDto(ticket);
    }

    @Override
    public void delete(Long id) {
        ticketrepository.deleteById(id);

    }

    @Override
    public List<TicketResponseDto> getAll() {
        List<Ticket> ticket = ticketrepository.findAll();
        return TicketMapper.entityToList(ticket);
    }

    @Override
    public List<TicketResponseDto> findAllBySeatNumber(String seatNumber) {
        List<Ticket> tickets = ticketrepository.findAllBySeatNumber(seatNumber);
        return TicketMapper.entityToList(tickets);
    }

    @Override
    public List<TicketResponseDto> findAllByPrice(double price) {
        List<Ticket> tickets = ticketrepository.findAllByPrice(price);
        return TicketMapper.entityToList(tickets);
    }

    @Override
    public void updateSeatNumber(Long id, String seatNumber) {
        Ticket ticket = ticketrepository.findById(id).get();
        ticket.setSeatNumber(seatNumber);
        ticketrepository.save(ticket);
    }

    @Override
    public void updatePrice(Long id, double price) {
        Ticket ticket = ticketrepository.findById(id).get();
        ticket.setPrice(price);
        ticketrepository.save(ticket);
    }
}
