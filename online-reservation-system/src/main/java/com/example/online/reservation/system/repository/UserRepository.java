package com.example.online.reservation.system.repository;

import com.example.online.reservation.system.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAllByUsername(String username);

    List<User> findAllByPhoneNumber(String phoneNumber);

    List<User> findAllByAddress(String address);

}
