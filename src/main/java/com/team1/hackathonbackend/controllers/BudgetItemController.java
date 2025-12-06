package com.team1.hackathonbackend.controllers;

import com.team1.hackathonbackend.domain.dto.BudgetItemDto;
import com.team1.hackathonbackend.domain.entities.BudgetItem;
import com.team1.hackathonbackend.mappers.BudgetItemMapper;
import com.team1.hackathonbackend.services.BudgetItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget-items")
public class BudgetItemController {

    private final BudgetItemMapper budgetItemMapper;
    private final BudgetItemService budgetItemService;

    public BudgetItemController(BudgetItemMapper budgetItemMapper, BudgetItemService budgetItemService) {
        this.budgetItemMapper = budgetItemMapper;
        this.budgetItemService = budgetItemService;
    }

    @PostMapping
    public ResponseEntity<BudgetItemDto> createBudgetItem(@RequestBody BudgetItemDto budgetItemDto) {
        System.out.println(budgetItemDto.getId());
        BudgetItem budgetItem = budgetItemService.createBudgetItem(budgetItemMapper.toEntity(budgetItemDto));
        System.out.println(budgetItem.getId());
        System.out.println(budgetItemMapper.toDto(budgetItem).getId());
        return new ResponseEntity<>(budgetItemMapper.toDto(budgetItem), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BudgetItemDto>> getAllBudgetItems() {
        List<BudgetItem> budgetItems = budgetItemService.getAllBudgetItems();
        return new ResponseEntity<>(budgetItemMapper.toListDto(budgetItems), HttpStatus.OK);
    }
}
