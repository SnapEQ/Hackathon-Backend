package com.team1.hackathonbackend.controllers;

import com.team1.hackathonbackend.domain.dto.CreateUserRequestDto;
import com.team1.hackathonbackend.domain.dto.UserDto;
import com.team1.hackathonbackend.domain.entities.CreateUserRequest;
import com.team1.hackathonbackend.domain.entities.User;
import com.team1.hackathonbackend.mappers.UserMapper;
import com.team1.hackathonbackend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = users.stream().map(userMapper::toDto).toList();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @Valid @RequestBody CreateUserRequestDto createUserRequestDto
    ){
      CreateUserRequest createUserRequest = userMapper.toCreateUserRequest(createUserRequestDto);
      User createdUser = userService.createUser(new User(), createUserRequest);
      UserDto userDto = userMapper.toDto(createdUser);
      return new ResponseEntity<>(userDto, HttpStatus.CREATED);

    }
}
