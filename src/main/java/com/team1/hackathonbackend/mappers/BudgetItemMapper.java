package com.team1.hackathonbackend.mappers;

import com.team1.hackathonbackend.domain.dto.BudgetItemDto;
import com.team1.hackathonbackend.domain.entities.BudgetItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BudgetItemMapper {
    BudgetItemDto toDto(BudgetItem budgetItem);
    BudgetItem toEntity(BudgetItemDto budgetItemDto);
    List<BudgetItemDto> toListDto(List<BudgetItem> budgetItems);
}
