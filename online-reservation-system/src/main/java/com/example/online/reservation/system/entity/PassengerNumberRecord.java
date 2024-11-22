package com.example.online.reservation.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "PassengerNumberRecord")
public class PassengerNumberRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pnr_number", unique = true, nullable = false)
    private String pnrNumber;

    @Column(name = "user_id")
    private User user;

    @Column(name = "journey_date", nullable = false)
    private LocalDateTime journeyDate;

    @Column(name = "cancellation_date", nullable = false)
    private LocalDateTime cancellationDate;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Train train;

}
