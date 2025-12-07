package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.BudgetItem;
import com.team1.hackathonbackend.domain.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetItemRepository extends JpaRepository<BudgetItem, Long> {
    List<BudgetItem> findAllByDepartmentId(Long departmentId);

    List<BudgetItem> findAllByDepartment(Department department);
}
