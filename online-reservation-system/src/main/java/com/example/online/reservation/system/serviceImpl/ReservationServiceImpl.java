package com.example.online.reservation.system.serviceImpl;

import com.example.online.reservation.system.dto.ReservationRequestDto;
import com.example.online.reservation.system.dto.ReservationResponseDto;
import com.example.online.reservation.system.entity.Reservation;
import com.example.online.reservation.system.mapper.ReservationMapper;
import com.example.online.reservation.system.repository.ReservationRepository;
import com.example.online.reservation.system.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void create(ReservationRequestDto reservationRequestDto) {
        Reservation reservation = ReservationMapper.dtoToEntity(reservationRequestDto);
        reservationRepository.save(reservation);
    }

    @Override
    public ReservationResponseDto getById(Long id) {
        Reservation reservation = reservationRepository.findById(id).get();
        return ReservationMapper.entityToDto(reservation);
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public List<ReservationResponseDto> getAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return ReservationMapper.entityToList(reservations);
    }

    @Override
    public List<ReservationResponseDto> findAllByTrainNumber(String trainNumber) {
        List<Reservation> reservations = reservationRepository.findAllByTrainNumber(trainNumber);
        return ReservationMapper.entityToList(reservations);
    }

    @Override
    public List<ReservationResponseDto> findAllByFromLocation(String fromLocation) {
        List<Reservation> reservations = reservationRepository.findAllByFromLocation(fromLocation);

        return ReservationMapper.entityToList(reservations);
    }

    @Override
    public void update(Long id, ReservationRequestDto reservation) {
        Reservation reservations = reservationRepository.findById(id).get();
        reservations.setReservationStatus(reservation.getReservationStatus());
        reservations.setClassType(reservation.getClassType());
        reservations.setFromLocation(reservation.getFromLocation());
        reservations.setJourneyDate(reservation.getJourneyDate());
        reservations.setTrainNumber(reservation.getTrainNumber());
        reservations.setTrainName(reservation.getTrainName());
        reservations.setPicketPrice(reservation.getPicketPrice());
        reservations.setToLocation(reservation.getToLocation());
        reservations.setFromLocation(reservation.getFromLocation());
        reservationRepository.save(reservations);
    }

    @Override
    public void updateToLocation(Long id, String toLocation) {
        Reservation reservations = reservationRepository.findById(id).get();
        reservations.setToLocation(toLocation);

    }

    @Override
    public void updateFromLocation(Long id, String fromLocation) {
        Reservation reservations = reservationRepository.findById(id).get();
        reservations.setFromLocation(fromLocation);
    }
}
