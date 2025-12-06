package com.team1.hackathonbackend.services;

import com.team1.hackathonbackend.domain.entities.CreateDepartmentRequest;
import com.team1.hackathonbackend.domain.entities.Department;


import java.util.List;


public interface DepartmentService {

    Department createDepartment(Department department, CreateDepartmentRequest createDepartmentRequest);

    Department getDepartmentById(Long id);

    List<Department> getAllDepartments();
}
