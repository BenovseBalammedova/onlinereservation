package com.example.online.reservation.system.serviceImpl;

import com.example.online.reservation.system.dto.TrainRequestDto;
import com.example.online.reservation.system.dto.TrainResponseDto;
import com.example.online.reservation.system.entity.Train;
import com.example.online.reservation.system.mapper.TrainMapper;
import com.example.online.reservation.system.repository.TrainRepository;
import com.example.online.reservation.system.service.TrainService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainrepostitory;

    public TrainServiceImpl(TrainRepository trainrepostitory) {
        this.trainrepostitory = trainrepostitory;
    }

    @Override
    public void create(TrainRequestDto trainRequestDto) {
        Train train = TrainMapper.dtoToEntity(trainRequestDto);
        trainrepostitory.save(train);


    }

    @Override
    public TrainResponseDto getById(Long id) {
        Train train = trainrepostitory.findById(id).get();
        return TrainMapper.entityToDto(train);
    }

    @Override
    public void delete(Long id) {
        trainrepostitory.deleteById(id);

    }

    @Override
    public List<TrainResponseDto> getAll() {
        List<Train> trains = trainrepostitory.findAll();
        return TrainMapper.entityToList(trains);
    }

    @Override
    public List<TrainResponseDto> findAllByTrainNumber(String trainNumber) {
        List<Train> trains = trainrepostitory.findAllByTrainNumber(trainNumber);
        return TrainMapper.entityToList(trains);
    }

    @Override
    public List<TrainResponseDto> findAllByTrainName(String name) {
        List<Train> trains = trainrepostitory.findAllByTrainName(name);
        return TrainMapper.entityToList(trains);
    }

    @Override
    public void update(Long id, TrainRequestDto trainRequestDto) {
        Train train = trainrepostitory.findById(id).get();
        train.setTrainName(trainRequestDto.getTrainName());
        train.setTrainNumber(trainRequestDto.getTrainNumber());
        train.setArrivalTime(trainRequestDto.getArrivalTime());
        train.setClassType(trainRequestDto.getClassType());
        train.setAvailableSeats(trainRequestDto.getAvailableSeats());
        train.setDepartureTime(trainRequestDto.getDepartureTime());
        train.setToLocation(trainRequestDto.getToLocation());
        train.setFromLocation(trainRequestDto.getFromLocation());
        trainrepostitory.save(train);
    }

    @Override
    public void updateDepartureTime(Long id, LocalDateTime departureTime) {
        Train train = trainrepostitory.findById(id).get();
        train.setDepartureTime(departureTime);
        trainrepostitory.save(train);

    }

    @Override
    public void updateTrainName(Long id, String trainName) {
        Train train = trainrepostitory.findById(id).get();
        train.setTrainName(trainName);
        trainrepostitory.save(train);
    }
}
