package com.example.online.reservation.system.controller;

import com.example.online.reservation.system.dto.UserRequestDto;
import com.example.online.reservation.system.dto.UserResponseDto;
import com.example.online.reservation.system.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/user/create")
    public void create(@RequestBody UserRequestDto userRequestDto) {
        service.create(userRequestDto);


    }

    @GetMapping("/user/{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        return service.getById(id);

    }

    @DeleteMapping("/user/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);

    }

    @GetMapping("/user/get-all")
    public List<UserResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/user/get/username")
    public List<UserResponseDto> findAllByUsername(@PathVariable String username) {
        return service.findAllByUsername(username);
    }

    @GetMapping("/user/get/phone_number")
    public List<UserResponseDto> findAllByPhoneNumber(@PathVariable String phoneNumber) {
        return service.findAllByPhoneNumber(phoneNumber);
    }

    @GetMapping("/user/get/address")
    public List<UserResponseDto> findAllByAddress(@PathVariable String address) {
        return service.findAllByAddress(address);

    }

    @PutMapping("user/update/{id}")
    public void update(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        service.update(id, userRequestDto);

    }

    @PutMapping("user/update/{address}/{id}")
    public void updateAddress(@PathVariable Long id, @RequestBody String address) {
        service.updateAddress(id, address);
    }

    @PutMapping("user/update/{email}/{id}")
    public void updateEmail(@PathVariable Long id, @RequestBody String email) {
        service.updateEmail(id, email);

    }

}
