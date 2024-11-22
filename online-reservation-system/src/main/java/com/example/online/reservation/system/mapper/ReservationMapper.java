package com.example.online.reservation.system.mapper;

import com.example.online.reservation.system.dto.ReservationRequestDto;
import com.example.online.reservation.system.dto.ReservationResponseDto;
import com.example.online.reservation.system.entity.Reservation;
import com.example.online.reservation.system.enums.ClassType;
import com.example.online.reservation.system.enums.ReservationStatus;

import java.time.LocalDate;
import java.util.List;

public class ReservationMapper {
    public static ReservationResponseDto entityToDto(Reservation reservation) {
        return ReservationResponseDto.builder()
                .fromLocation(reservation.getFromLocation())
                .classType(reservation.getClassType())
                .toLocation(reservation.getToLocation())
                .trainName(reservation.getTrainName())
                .trainNumber(reservation.getTrainNumber())
                .cancellation(CancellationMapper.entityToDto(reservation.getCancellation()))
                .reservationStatus(reservation.getReservationStatus())
                .cancelledAt(reservation.getCancelledAt())
                .journeyDate(reservation.getJourneyDate())
                .payment(PaymentMapper.entityToDto(reservation.getPayment()))
                .passengerNumberRecord(PassengerNumberRecordMapper.entityToDto(reservation.getPassengerNumberRecord()))
                .picketPrice(reservation.getPicketPrice())
                .trainresponsedto(TrainMapper.entityToDto(reservation.getTrain()))
                .user(UserMapper.entityToDto(reservation.getUser()))
                .build();


    }

    public static Reservation dtoToEntity(ReservationRequestDto reservationrequest) {
        return Reservation.builder()
                .trainNumber(reservationrequest.getTrainNumber())
                .trainName(reservationrequest.getTrainName())
                .reservationStatus(reservationrequest.getReservationStatus())
                .fromLocation(reservationrequest.getFromLocation())
                .classType(reservationrequest.getClassType())
                .picketPrice(reservationrequest.getPicketPrice())
                .toLocation(reservationrequest.getToLocation())
                .journeyDate(reservationrequest.getJourneyDate())
                .build();
    }

    public static List<ReservationResponseDto> entityToList(List<Reservation> reservation) {
        return reservation.stream().map(ReservationMapper::entityToDto).toList();
    }

}
