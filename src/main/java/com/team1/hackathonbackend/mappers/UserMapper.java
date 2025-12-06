package com.team1.hackathonbackend.mappers;

import com.team1.hackathonbackend.domain.dto.CreateUserRequestDto;
import com.team1.hackathonbackend.domain.dto.UserDto;
import com.team1.hackathonbackend.domain.entities.CreateUserRequest;
import com.team1.hackathonbackend.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto toDto(User user);

    CreateUserRequest toCreateUserRequest(CreateUserRequestDto createUserRequestDto);


}
