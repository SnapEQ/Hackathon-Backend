package com.team1.hackathonbackend.services;

import com.team1.hackathonbackend.domain.entities.BudgetItem;

import java.util.List;

public interface BudgetItemService {
    BudgetItem createBudgetItem(BudgetItem budgetItem);
    List<BudgetItem> getAllBudgetItems();
}
