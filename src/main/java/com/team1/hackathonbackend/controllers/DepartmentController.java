package com.team1.hackathonbackend.controllers;

import com.team1.hackathonbackend.domain.dto.DepartmentDto;
import com.team1.hackathonbackend.domain.entities.Department;
import com.team1.hackathonbackend.mappers.DepartmentMapper;
import com.team1.hackathonbackend.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<Department> departments = departmentService.getAllDepartments();
        List<DepartmentDto> departmentDtos = departments.stream().map(departmentMapper::toDto).toList();
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

}
