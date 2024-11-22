package com.example.online.reservation.system.serviceImpl;

import com.example.online.reservation.system.dto.CancellationRequestDto;
import com.example.online.reservation.system.dto.CancellationResponseDto;
import com.example.online.reservation.system.entity.Cancellation;
import com.example.online.reservation.system.enums.CancellationStatus;
import com.example.online.reservation.system.mapper.CancellationMapper;
import com.example.online.reservation.system.repository.CancellationRepository;
import com.example.online.reservation.system.service.CancellationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service

public class CancellationServiceImpl implements CancellationService {
    private final CancellationRepository cancellationRepository;

    public CancellationServiceImpl(CancellationRepository cancellationRepository) {
        this.cancellationRepository = cancellationRepository;
    }

    @Override
    public void create(CancellationRequestDto cancellationRequestDto) {
        Cancellation cancellation = CancellationMapper.dtoToEntity(cancellationRequestDto);
        cancellationRepository.save(cancellation);

    }

    @Override
    public CancellationResponseDto getById(Long id) {
        Cancellation cancellation = cancellationRepository.findById(id).get();
        return CancellationMapper.entityToDto(cancellation);
    }

    @Override
    public void delete(Long id) {
        cancellationRepository.deleteById(id);

    }

    @Override
    public List<CancellationResponseDto> getAll() {
        List<Cancellation> cancellations = cancellationRepository.findAll();
        return CancellationMapper.entityToList(cancellations);
    }

    @Override
    public List<CancellationResponseDto> findAllByPnrNumber(String pnrNumber) {
        List<Cancellation> cancellations = cancellationRepository.findAllByPnrNumber(pnrNumber);
        return CancellationMapper.entityToList(cancellations);
    }

    @Override
    public List<CancellationResponseDto> findAllByCancellationDate(LocalDate cancellationDate) {
        List<Cancellation> cancellations = cancellationRepository.findAllByCancellationDate(cancellationDate);
        return CancellationMapper.entityToList(cancellations);
    }

    @Override
    public void update(Long id, CancellationRequestDto cancellationRequestDto) {
        Cancellation cancellation = cancellationRepository.findById(id).get();
        cancellation.setCancellationDate(cancellationRequestDto.getCancellationDate());
        cancellation.setStatus(cancellationRequestDto.getStatus());
        cancellation.setPnrNumber(cancellationRequestDto.getPnrNumber());
        cancellationRepository.save(cancellation);

    }

    @Override
    public void updatePnrNumber(Long id, String pnrNumber) {
        Cancellation cancellation = cancellationRepository.findById(id).get();
        cancellation.setPnrNumber(pnrNumber);
        cancellationRepository.save(cancellation);

    }

    @Override
    public void updateStatus(Long id, CancellationStatus status) {
        Cancellation cancellation = cancellationRepository.findById(id).get();
        cancellation.setStatus(status);
        cancellationRepository.save(cancellation);
    }
}
