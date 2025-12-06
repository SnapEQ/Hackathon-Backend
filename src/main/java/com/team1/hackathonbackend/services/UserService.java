package com.team1.hackathonbackend.services;

import com.team1.hackathonbackend.domain.entities.CreateUserRequest;
import com.team1.hackathonbackend.domain.entities.Department;
import com.team1.hackathonbackend.domain.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user, CreateUserRequest createUserRequest);

    User getUserById(Long id);

    List<User> getAllUsers();

    List<User> getAllUsersByDepartment(Department department);
}
