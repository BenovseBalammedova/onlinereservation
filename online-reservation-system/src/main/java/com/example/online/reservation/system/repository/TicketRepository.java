package com.example.online.reservation.system.repository;

import com.example.online.reservation.system.dto.TicketResponseDto;
import com.example.online.reservation.system.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findAllBySeatNumber(String seatNumber);

    List<Ticket> findAllByPrice(double price);
}
