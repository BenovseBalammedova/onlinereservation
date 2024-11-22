package com.example.online.reservation.system.mapper;

import com.example.online.reservation.system.dto.TrainRequestDto;
import com.example.online.reservation.system.dto.TrainResponseDto;
import com.example.online.reservation.system.entity.Train;


import java.util.List;

public class TrainMapper {
    public static TrainResponseDto entityToDto(Train train) {
        return TrainResponseDto.builder()
                .arrivalTime(train.getArrivalTime())
                .availableSeats(train.getAvailableSeats())
                .classType(train.getClassType())
                .departureTime(train.getDepartureTime())
                .fromLocation(train.getFromLocation())
                .trainName(train.getTrainName())
                .trainNumber(train.getTrainNumber())
                .reservations(ReservationMapper.entityToList(train.getReservations()))
                .passengerNumberRecords(PassengerNumberRecordMapper.entityToList(train.getPassengerNumberRecords()))
                .toLocation(train.getToLocation())
                .build();

    }

    public static Train dtoToEntity(TrainRequestDto traindto) {
        return Train.builder()
                .classType(traindto.getClassType())
                .trainName(traindto.getTrainName())
                .trainNumber(traindto.getTrainNumber())
                .departureTime(traindto.getDepartureTime())
                .fromLocation(traindto.getFromLocation())
                .availableSeats(traindto.getAvailableSeats())
                .toLocation(traindto.getToLocation())
                .arrivalTime(traindto.getArrivalTime())
                .build();

    }

    public static List<TrainResponseDto> entityToList(List<Train> train) {
        return train.stream().map(TrainMapper::entityToDto).toList();

    }

}
