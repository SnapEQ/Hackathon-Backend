package com.team1.hackathonbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BudgetItemRevisionDto {
    private Long revisionNumber;
    private Long revisionTimestamp;  // Epoch millis
    private String revisionType;  // ADDED, UPDATED, DELETED
    private BudgetItemDto entity;
}
