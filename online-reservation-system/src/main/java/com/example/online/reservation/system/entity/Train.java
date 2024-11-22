package com.example.online.reservation.system.entity;

import com.example.online.reservation.system.enums.ClassType;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_number",unique = true,nullable = false)
    private String trainNumber;

    @Column(name = "train_name")
    private String trainName;

    @Enumerated(EnumType.STRING)

    private ClassType classType;

    @Column(name = "available_seats")
    private int availableSeats;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "from_location")
    private String fromLocation;

    @Column(name = "to_location")
    private String toLocation;

    @OneToMany(mappedBy = "train")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "train")
    private List<PassengerNumberRecord> passengerNumberRecords;

}
