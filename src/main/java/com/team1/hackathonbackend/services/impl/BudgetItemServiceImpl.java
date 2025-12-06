package com.team1.hackathonbackend.services.impl;

import com.team1.hackathonbackend.domain.entities.BudgetItem;
import com.team1.hackathonbackend.repositories.BudgetItemRepository;
import com.team1.hackathonbackend.services.BudgetItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetItemServiceImpl implements BudgetItemService {
    private BudgetItemRepository budgetItemRepository;

    @Autowired
    public BudgetItemServiceImpl(BudgetItemRepository budgetItemRepository) {
        this.budgetItemRepository = budgetItemRepository;
    }

    public BudgetItem createBudgetItem(BudgetItem budgetItem) {
        // TODO Add proper validation
        // TODO Add proper user validation
        return budgetItemRepository.save(budgetItem);
    }

    public List<BudgetItem> getAllBudgetItems() {
        // TODO add proper user validation
        return budgetItemRepository.findAll();
    }
}
