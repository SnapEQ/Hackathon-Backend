package com.team1.hackathonbackend.mappers;

import com.team1.hackathonbackend.domain.dto.BudgetItemDto;
import com.team1.hackathonbackend.domain.entities.BudgetItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BudgetItemMapper {
    @Mapping(target = "budgetPartId", source = "budgetPart.id")
    @Mapping(target = "sectionId", source = "section.id")
    @Mapping(target = "subSectionId", source = "subSection.id")
    @Mapping(target = "paragraphId", source = "paragraph.id")
    @Mapping(target = "financeSourceId", source = "financeSource.id")
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "actionId", source = "action.id")
    BudgetItemDto toDto(BudgetItem budgetItem);

    BudgetItem toEntity(BudgetItemDto budgetItemDto);

    @Mapping(target = "budgetPartId", source = "budgetPart.id")
    @Mapping(target = "sectionId", source = "section.id")
    @Mapping(target = "subSectionId", source = "subSection.id")
    @Mapping(target = "paragraphId", source = "paragraph.id")
    @Mapping(target = "financeSourceId", source = "financeSource.id")
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "actionId", source = "action.id")
    List<BudgetItemDto> toListDto(List<BudgetItem> budgetItems);
}
