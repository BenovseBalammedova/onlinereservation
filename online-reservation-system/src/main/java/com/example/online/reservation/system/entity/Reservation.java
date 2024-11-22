package com.example.online.reservation.system.entity;

import com.example.online.reservation.system.enums.ClassType;

import com.example.online.reservation.system.enums.ReservationStatus;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "train_number", nullable = false)
    private String trainNumber;

    @Column(name = "train_name", nullable = false)
    private String trainName;

    @Column(name = "journey_date", nullable = false)
    private LocalDate journeyDate;

    @Column(name = "from_location", nullable = false)
    private String fromLocation;

    @Column(name = "to_location", nullable = false)
    private String toLocation;

    @Column(name = "picket_price")
    private double picketPrice;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;

    @Enumerated(EnumType.STRING)

    private ClassType classType;


    @Enumerated(EnumType.STRING)

    private ReservationStatus reservationStatus;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "reservation")
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Train train;

    @OneToOne(mappedBy = "reservation")
    private Payment payment;

    @OneToOne(mappedBy = "reservation")
    private Cancellation cancellation;

    @OneToOne(mappedBy = "reservation")
    private PassengerNumberRecord passengerNumberRecord;


}
