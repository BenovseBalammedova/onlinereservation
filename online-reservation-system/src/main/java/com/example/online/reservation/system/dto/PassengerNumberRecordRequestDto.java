package com.example.online.reservation.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerNumberRecordRequestDto {

    private String pnrNumber;

    private LocalDateTime journeyDate;

    private LocalDateTime cancellationDate;

    private String status;

}
