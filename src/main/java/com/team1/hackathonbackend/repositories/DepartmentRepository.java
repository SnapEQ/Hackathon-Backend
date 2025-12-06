package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
}
