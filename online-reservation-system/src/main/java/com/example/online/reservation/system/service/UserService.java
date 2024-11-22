package com.example.online.reservation.system.service;

import com.example.online.reservation.system.dto.UserRequestDto;
import com.example.online.reservation.system.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    void create(UserRequestDto userRequestDto);

    UserResponseDto getById(Long id);

    void delete(Long id);

    List<UserResponseDto> getAll();

    List<UserResponseDto> findAllByUsername(String username);

    List<UserResponseDto> findAllByPhoneNumber(String phoneNumber);

    List<UserResponseDto> findAllByAddress(String address);

    void update(Long id, UserRequestDto userRequestDto);

    void updateAddress(Long id, String address);

    void updateEmail(Long id, String email);


}

