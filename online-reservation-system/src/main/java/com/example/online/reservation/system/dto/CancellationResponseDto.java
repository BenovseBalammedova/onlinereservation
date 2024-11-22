package com.example.online.reservation.system.dto;
import com.example.online.reservation.system.enums.CancellationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancellationResponseDto {

    private String pnrNumber;

    private LocalDate cancellationDate;

    private CancellationStatus status;

    private ReservationResponseDto reservation;
}
