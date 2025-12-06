package com.team1.hackathonbackend.domain.dto;

import com.team1.hackathonbackend.domain.entities.Department;
import com.team1.hackathonbackend.domain.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private Role role;
    private Department department;
}
