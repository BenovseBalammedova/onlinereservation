package com.example.online.reservation.system.mapper;

import com.example.online.reservation.system.dto.*;
import com.example.online.reservation.system.entity.PassengerNumberRecord;

import java.util.List;


public class PassengerNumberRecordMapper {
    public static PassengerNumberRecordResponseDto entityToDto(PassengerNumberRecord pnrresponse) {
        return PassengerNumberRecordResponseDto.builder()
                .cancellationDate(pnrresponse.getCancellationDate())
                .journeyDate(pnrresponse.getJourneyDate())
                .pnrNumber(pnrresponse.getPnrNumber())
                .reservation(ReservationMapper.entityToDto(pnrresponse.getReservation()))
                .train(TrainMapper.entityToDto(pnrresponse.getTrain()))
                .user(UserMapper.entityToDto(pnrresponse.getUser()))
                .status(pnrresponse.getStatus())
                .build();
    }

    public static PassengerNumberRecord dtoToEntity(PassengerNumberRecordRequestDto pnrrequest) {
        return PassengerNumberRecord.builder()
                .cancellationDate(pnrrequest.getCancellationDate())
                .pnrNumber(pnrrequest.getPnrNumber())
                .journeyDate(pnrrequest.getJourneyDate())
                .status(pnrrequest.getStatus())
                .build();
    }

    public static List<PassengerNumberRecordResponseDto> entityToList(List<PassengerNumberRecord> pnrresponse) {
        return pnrresponse.stream().map(PassengerNumberRecordMapper::entityToDto).toList();

    }
}







