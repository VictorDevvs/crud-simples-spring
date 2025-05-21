package com.victordevvs.crudsimples.service;

import com.victordevvs.crudsimples.dto.UserRequestDto;
import com.victordevvs.crudsimples.dto.UserResponseDto;
import com.victordevvs.crudsimples.exception.ExistingEmailException;
import com.victordevvs.crudsimples.exception.UserNotFoundException;
import com.victordevvs.crudsimples.mapper.UserMapper;
import com.victordevvs.crudsimples.model.User;
import com.victordevvs.crudsimples.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserResponseDto save(UserRequestDto userRequestDto) {
        userRepository.findByEmail(userRequestDto.getEmail()).ifPresent(u -> {
            throw new ExistingEmailException("The email is already in use");
        });
        User user = userMapper.toModel(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserResponseDto findById(Long id){
        return userRepository.findById(id).map(userMapper::toDto).orElseThrow(() ->
                new UserNotFoundException("User not found with id: " + id));
    }

    @Transactional
    public UserResponseDto replace(Long id, UserRequestDto userRequestDto){
        User user = userRepository.findById(id).map(u -> {
            u.setName(userRequestDto.getName());
            u.setEmail(userRequestDto.getEmail());
            u.setPassword(userRequestDto.getPassword());
            return userRepository.save(u);
        }).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        return userMapper.toDto(user);
    }

    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow( () ->
                new UserNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }
}
