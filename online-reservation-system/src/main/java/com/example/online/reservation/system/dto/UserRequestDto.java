package com.example.online.reservation.system.dto;

import com.example.online.reservation.system.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {

    private String username;

    private String fullName;

    private String password;

    private String phoneNumber;

    private String address;

    private String email;

    private LocalDate dateOfBirth;

    private Role role;

}
