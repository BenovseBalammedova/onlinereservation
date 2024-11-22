package com.example.online.reservation.system.entity;

import com.example.online.reservation.system.enums.CancellationStatus;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Cancellation")
public class Cancellation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancellationId")
    private Long cancellationId;

    @Column(name = "pnr_number", nullable = false)
    private String pnrNumber;

    @Column(nullable = false)
    private LocalDate cancellationDate;

    @Enumerated(EnumType.STRING)

    private CancellationStatus status;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Reservation reservation;


}
