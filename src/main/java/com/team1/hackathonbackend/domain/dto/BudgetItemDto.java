package com.team1.hackathonbackend.domain.dto;

import com.team1.hackathonbackend.domain.entities.dicts.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetItemDto {
    private Long id;
    private BudgetPart budgetPart;
    private Section section;
    private SubSection subSection;
    private Paragraph paragraph;
    private FinanceSource financeSource;
    private String test;
}
