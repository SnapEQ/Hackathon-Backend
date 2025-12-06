package com.team1.hackathonbackend.services.impl;

import com.team1.hackathonbackend.domain.entities.CreateUserRequest;
import com.team1.hackathonbackend.domain.entities.Department;
import com.team1.hackathonbackend.domain.entities.User;
import com.team1.hackathonbackend.repositories.DepartmentRepository;
import com.team1.hackathonbackend.repositories.UserRepository;
import com.team1.hackathonbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    public User createUser(User user, CreateUserRequest createUserRequest) {
        User newUser = new User();
        newUser.setUsername(createUserRequest.getUsername());
        newUser.setPassword(createUserRequest.getPassword());
        newUser.setRole(createUserRequest.getRole());

        newUser.setDepartment(
                departmentRepository.findById(
                createUserRequest.getDepartmentId())
                        .orElseThrow(() -> new IllegalArgumentException(
                        "Department not found: " + createUserRequest.getDepartmentId()))

        );

        return userRepository.save(newUser);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsersByDepartment(Department department) {
        return userRepository.findAllByDepartment(department);
    }




}
