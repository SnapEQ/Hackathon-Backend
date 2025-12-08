package com.team1.hackathonbackend.services;

import com.team1.hackathonbackend.domain.dto.BudgetItemDto;
import com.team1.hackathonbackend.domain.entities.BudgetItem;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface BudgetItemService {
    BudgetItem createBudgetItem(BudgetItemDto budgetItemDto);
    List<BudgetItem> getAllBudgetItems();
    BudgetItem updatePartialBudgetItem(Long id, BudgetItemDto dto);
    BudgetItem getBudgetItemById(Long id);
    List<BudgetItem> getBudgetItemByDepartmentId(Long departmentId);

//    BudgetItem findByIdForUpdate(Long budgetItemId);
//
//    @Transactional
//    Optional<BudgetItem> tryLockForEditing(Long budgetItemId);
//
//    @Transactional
//    BudgetItem lockForReading(Long budgetItemId);
}
