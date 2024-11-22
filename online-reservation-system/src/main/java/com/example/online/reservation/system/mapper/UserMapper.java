package com.example.online.reservation.system.mapper;

import com.example.online.reservation.system.dto.UserRequestDto;
import com.example.online.reservation.system.dto.UserResponseDto;
import com.example.online.reservation.system.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserMapper {
    public static UserResponseDto entityToDto(User user) {
        return UserResponseDto.builder()
                .username(user.getUsername())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .dateOfBirth(user.getDateOfBirth())
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .reservations(ReservationMapper.entityToList(user.getReservations()))
                .build();
    }

    public static User dtoToEntity(UserRequestDto userdto) {
        return User.builder()
                .address(userdto.getAddress())
                .password(userdto.getPassword())
                .phoneNumber(userdto.getPhoneNumber())
                .role(userdto.getRole())
                .email(userdto.getEmail())
                .dateOfBirth(userdto.getDateOfBirth())
                .fullName(userdto.getFullName())
                .username(userdto.getUsername())
                .build();
    }

    public static List<UserResponseDto> entityToList(List<User> user) {
        return user.stream().map(UserMapper::entityToDto).toList();
    }

}
