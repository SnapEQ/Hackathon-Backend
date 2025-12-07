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
@RequestMapping("/api/budget-items")
public class BudgetItemController {

    private final BudgetItemMapper budgetItemMapper;
    private final BudgetItemService budgetItemService;

    public BudgetItemController(BudgetItemMapper budgetItemMapper, BudgetItemService budgetItemService) {
        this.budgetItemMapper = budgetItemMapper;
        this.budgetItemService = budgetItemService;
    }

    @PostMapping
    public ResponseEntity<BudgetItemDto> createBudgetItem(@RequestBody BudgetItemDto budgetItemDto) {
        BudgetItem budgetItem = budgetItemService.createBudgetItem(budgetItemMapper.toEntity(budgetItemDto));
        return new ResponseEntity<>(budgetItemMapper.toDto(budgetItem), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BudgetItemDto>> getAllBudgetItems() {
        List<BudgetItem> budgetItems = budgetItemService.getAllBudgetItems();
        return new ResponseEntity<>(budgetItemMapper.toListDto(budgetItems), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BudgetItemDto> updatePartialBudgetItem(
            @PathVariable Long id,
            @RequestBody BudgetItemDto budgetItemDto) {
        BudgetItem updatedBudgetItem = budgetItemService.updatePartialBudgetItem(id, budgetItemMapper.toEntity(budgetItemDto));
        return new ResponseEntity<>(budgetItemMapper.toDto(updatedBudgetItem), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetItemDto> getBudgetItemById(@PathVariable Long id) {
        BudgetItem budgetItem = budgetItemService.getBudgetItemById(id);
        return new ResponseEntity<>(budgetItemMapper.toDto(budgetItem), HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<List<BudgetItemDto>> getBudgetItemByDepartmentId(@PathVariable Long id) {
        List<BudgetItem> budgetItems = budgetItemService.getBudgetItemByDepartmentId(id);
        System.out.println(budgetItems);
        List<BudgetItemDto> budgetItemsDto = budgetItemMapper.toListDto(budgetItems);
        return new ResponseEntity<>(budgetItemsDto, HttpStatus.OK);

    }
}
