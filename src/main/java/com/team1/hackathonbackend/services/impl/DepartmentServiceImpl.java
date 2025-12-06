package com.team1.hackathonbackend.services.impl;

import com.team1.hackathonbackend.domain.entities.CreateDepartmentRequest;
import com.team1.hackathonbackend.domain.entities.Department;
import com.team1.hackathonbackend.repositories.DepartmentRepository;
import com.team1.hackathonbackend.services.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department, CreateDepartmentRequest createDepartmentRequest) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Department not found: " + id));
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
