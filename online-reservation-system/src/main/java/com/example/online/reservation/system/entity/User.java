package com.example.online.reservation.system.entity;

import com.example.online.reservation.system.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",unique = true,nullable = false)
    private String username;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "date_of_birth",nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)

    private Role role;

   @OneToMany(mappedBy = "user")
   private List<Reservation> reservations;
}
