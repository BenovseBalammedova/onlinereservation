package com.example.online.reservation.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tickedId;

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Reservation reservation;


}

