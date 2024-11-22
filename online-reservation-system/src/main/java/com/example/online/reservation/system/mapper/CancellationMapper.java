package com.example.online.reservation.system.mapper;

import com.example.online.reservation.system.dto.CancellationRequestDto;
import com.example.online.reservation.system.dto.CancellationResponseDto;
import com.example.online.reservation.system.entity.Cancellation;

import java.util.List;


public class CancellationMapper {
    public static CancellationResponseDto entityToDto(Cancellation cancellationresponse) {
        return CancellationResponseDto.builder()
                .cancellationDate(cancellationresponse.getCancellationDate())
                .pnrNumber(cancellationresponse.getPnrNumber())
                .status(cancellationresponse.getStatus())
                .reservation(ReservationMapper.entityToDto(cancellationresponse.getReservation()))
                .build();
    }

    public static Cancellation dtoToEntity(CancellationRequestDto cancellationRequest) {
        return Cancellation.builder()
                .cancellationDate(cancellationRequest.getCancellationDate())
                .pnrNumber(cancellationRequest.getPnrNumber())
                .status(cancellationRequest.getStatus())
                .reservation(ReservationMapper.dtoToEntity(cancellationRequest.getReservation()))
                .build();
    }

    public static List<CancellationResponseDto> entityToList(List<Cancellation> cancellations) {
        return cancellations.stream().map(CancellationMapper::entityToDto).toList();
    }
}












