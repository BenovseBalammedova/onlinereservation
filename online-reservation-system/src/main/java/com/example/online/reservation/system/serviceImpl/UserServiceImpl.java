package com.example.online.reservation.system.serviceImpl;

import com.example.online.reservation.system.dto.UserRequestDto;
import com.example.online.reservation.system.dto.UserResponseDto;
import com.example.online.reservation.system.entity.User;
import com.example.online.reservation.system.mapper.UserMapper;
import com.example.online.reservation.system.repository.UserRepository;
import com.example.online.reservation.system.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserRequestDto userRequestDto) {
      User user= UserMapper.dtoToEntity(userRequestDto);
      userRepository.save(user);
    }

    @Override
    public UserResponseDto getById(Long id) {
       User user= userRepository.findById(id).get();
        return UserMapper.entityToDto(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponseDto> getAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.entityToList(users);
    }

    @Override
    public List<UserResponseDto> findAllByUsername(String username) {
//        List<User> users=userRepository.findAll();
//        List<User> filteredUsers=users.stream().filter(user -> user.getUsername().equals(username)).toList();
//        return UserMapper.entityToList(filteredUsers);

        List<User>userList=userRepository.findAllByUsername(username);
        return UserMapper.entityToList(userList);

    }

    @Override
    public List<UserResponseDto> findAllByPhoneNumber(String phoneNumber) {
//        List<User>users=userRepository.findAll();
//        List<User> filteredUsers=users.stream().filter(user -> user.getPhoneNumber().equals(phoneNumber)).toList();
//        return UserMapper.entityToList(filteredUsers);
        List<User>userList=userRepository.findAllByPhoneNumber(phoneNumber);
        return UserMapper.entityToList(userList);
    }

    @Override
    public List<UserResponseDto> findAllByAddress(String address) {
        List<User> userList=userRepository.findAllByAddress(address);
        return UserMapper.entityToList(userList);
    }

    @Override
    public void update(Long id, UserRequestDto userRequestDto) {
        User user=userRepository.findById(id).get();
        user.setAddress(userRequestDto.getAddress());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setFullName(userRequestDto.getFullName());
        user.setDateOfBirth(userRequestDto.getDateOfBirth());
        user.setRole(userRequestDto.getRole());
        user.setUsername(userRequestDto.getUsername());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        userRepository.save(user);

    }

    @Override
    public void updateAddress(Long id, String address) {
        User user=userRepository.findById(id).get();
        user.setAddress(address);
        userRepository.save(user);


    }

    @Override
    public void updateEmail(Long id, String email) {
        User user=userRepository.findById(id).get();
        user.setEmail(email);
        userRepository.save(user);

    }
}
