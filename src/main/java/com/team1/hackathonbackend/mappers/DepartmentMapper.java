package com.team1.hackathonbackend.mappers;

import com.team1.hackathonbackend.domain.dto.DepartmentDto;
import com.team1.hackathonbackend.domain.entities.CreateDepartmentRequest;
import com.team1.hackathonbackend.domain.entities.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    DepartmentDto toDto(Department department);

    CreateDepartmentRequest toCreateDepartmentRequest(DepartmentDto departmentDto);
}
