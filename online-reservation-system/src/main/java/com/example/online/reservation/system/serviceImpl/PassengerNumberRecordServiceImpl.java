package com.example.online.reservation.system.serviceImpl;

import com.example.online.reservation.system.dto.PassengerNumberRecordRequestDto;
import com.example.online.reservation.system.dto.PassengerNumberRecordResponseDto;
import com.example.online.reservation.system.entity.PassengerNumberRecord;
import com.example.online.reservation.system.mapper.PassengerNumberRecordMapper;
import com.example.online.reservation.system.repository.PassengerNumberRecordRepository;
import com.example.online.reservation.system.service.PassengerNumberRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PassengerNumberRecordServiceImpl implements PassengerNumberRecordService {
    private final PassengerNumberRecordRepository pnrRepository;

    public PassengerNumberRecordServiceImpl(PassengerNumberRecordRepository pnrRepository) {
        this.pnrRepository = pnrRepository;
    }

    @Override
    public void create(PassengerNumberRecordRequestDto psnRequestDto) {
        PassengerNumberRecord pnr = PassengerNumberRecordMapper.dtoToEntity(psnRequestDto);
        pnrRepository.save(pnr);

    }

    @Override
    public PassengerNumberRecordResponseDto getById(Long id) {
        PassengerNumberRecord pnr = pnrRepository.findById(id).get();
        return PassengerNumberRecordMapper.entityToDto(pnr);
    }

    @Override
    public void delete(Long id) {
        pnrRepository.deleteById(id);

    }

    @Override
    public List<PassengerNumberRecordResponseDto> getAll() {
        List<PassengerNumberRecord> pnr = pnrRepository.findAll();
        return PassengerNumberRecordMapper.entityToList(pnr);
    }

    @Override
    public List<PassengerNumberRecordResponseDto> findAllByPnrNumber(String pnrNumber) {
        List<PassengerNumberRecord> pnr = pnrRepository.findAllByPnrNumber(pnrNumber);
        return PassengerNumberRecordMapper.entityToList(pnr);
    }

    @Override
    public List<PassengerNumberRecordResponseDto> findAllByStatus(String status) {
        List<PassengerNumberRecord> pnr = pnrRepository.findAllByStatus(status);
        return PassengerNumberRecordMapper.entityToList(pnr);
    }

    @Override
    public void update(Long id, PassengerNumberRecordRequestDto pnr) {
        PassengerNumberRecord passenger = pnrRepository.findById(id).get();
        passenger.setJourneyDate(pnr.getJourneyDate());
        passenger.setStatus(pnr.getStatus());
        passenger.setPnrNumber(pnr.getPnrNumber());
        pnrRepository.save(passenger);
    }

    @Override
    public void updateJourneyDate(Long id, LocalDateTime journeyDate) {
        PassengerNumberRecord passenger = pnrRepository.findById(id).get();
        passenger.setJourneyDate(journeyDate);
        pnrRepository.save(passenger);

    }

    @Override
    public void updatePnrNumber(Long id, String pnrNumber) {
        PassengerNumberRecord passenger = pnrRepository.findById(id).get();
        passenger.setPnrNumber(pnrNumber);
        pnrRepository.save(passenger);
    }
}
