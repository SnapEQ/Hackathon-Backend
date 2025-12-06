package com.team1.hackathonbackend.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequestDto {

    @NotBlank
    @Size(min = 3, max = 30, message = "Username mut be between {min} and {max} characters")
    private String username;

    @NotBlank
    @Size(min = 5, max = 20, message = "Password must be between {min} and {max} characters")
    private String password;

    @NotNull(message = "department id is required")
    private Long departmentId;
}
