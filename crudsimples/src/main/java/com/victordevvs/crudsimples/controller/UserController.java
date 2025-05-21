package com.victordevvs.crudsimples.controller;

import com.victordevvs.crudsimples.dto.UserRequestDto;
import com.victordevvs.crudsimples.dto.UserResponseDto;
import com.victordevvs.crudsimples.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto save(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.save(userRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto replace(@PathVariable Long id, @RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.replace(id, userRequestDto);
    }

}
