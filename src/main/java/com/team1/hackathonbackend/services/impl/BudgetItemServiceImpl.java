package com.team1.hackathonbackend.services.impl;

import com.team1.hackathonbackend.domain.dto.BudgetItemDto;
import com.team1.hackathonbackend.domain.entities.BudgetItem;
import com.team1.hackathonbackend.repositories.*;
import com.team1.hackathonbackend.services.BudgetItemService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.LockTimeoutException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BudgetItemServiceImpl implements BudgetItemService {
    private BudgetItemRepository budgetItemRepository;
    private final BudgetPartRepository budgetPartRepository;
    private final SectionRepository sectionRepository;
    private final SubSectionRepository subSectionRepository;
    private final ParagraphRepository paragraphRepository;
    private final FinanceSourceRepository financeSourceRepository;
    private final DepartmentRepository departmentRepository;
    private final ActionRepository actionRepository;

    @Autowired
    public BudgetItemServiceImpl(BudgetItemRepository budgetItemRepository, BudgetPartRepository budgetPartRepository, SectionRepository sectionRepository, SubSectionRepository subSectionRepository, ParagraphRepository paragraphRepository, FinanceSourceRepository financeSourceRepository, DepartmentRepository departmentRepository, ActionRepository actionRepository) {
        this.budgetItemRepository = budgetItemRepository;
        this.budgetPartRepository = budgetPartRepository;
        this.sectionRepository = sectionRepository;
        this.subSectionRepository = subSectionRepository;
        this.paragraphRepository = paragraphRepository;
        this.financeSourceRepository = financeSourceRepository;
        this.departmentRepository = departmentRepository;
        this.actionRepository = actionRepository;
    }

    @Override
    @Transactional
    public BudgetItem createBudgetItem(BudgetItemDto dto) {
        BudgetItem budgetItem = new BudgetItem();

        // Load related entities by ID (or throw EntityNotFoundException)
        if (dto.getBudgetPartId() != null) {
            budgetItem.setBudgetPart(
                    budgetPartRepository.findById(dto.getBudgetPartId())
                            .orElseThrow(() -> new RuntimeException("BudgetPart not found"))
            );
        }

        if (dto.getSectionId() != null) {
            budgetItem.setSection(
                    sectionRepository.findById(dto.getSectionId())
                            .orElseThrow(() -> new RuntimeException("Section not found"))
            );
        }

        if (dto.getSubSectionId() != null) {
            budgetItem.setSubSection(
                    subSectionRepository.findById(dto.getSubSectionId())
                            .orElseThrow(() -> new RuntimeException("SubSection not found"))
            );
        }

        if (dto.getParagraphId() != null) {
            budgetItem.setParagraph(
                    paragraphRepository.findById(dto.getParagraphId())
                            .orElseThrow(() -> new RuntimeException("Paragraph not found"))
            );
        }

        if (dto.getFinanceSourceId() != null) {
            budgetItem.setFinanceSource(
                    financeSourceRepository.findById(dto.getFinanceSourceId())
                            .orElseThrow(() -> new RuntimeException("FinanceSource not found"))
            );
        }

        if (dto.getDepartmentId() != null) {
            budgetItem.setDepartment(
                    departmentRepository.findById(dto.getDepartmentId())
                            .orElseThrow(() -> new RuntimeException("Department not found"))
            );
        }

        if (dto.getActionId() != null) {
            budgetItem.setAction(
                    actionRepository.findById(dto.getActionId())
                            .orElseThrow(() -> new RuntimeException("Action not found"))
            );
        }

        // Set scalar fields
        budgetItem.setExpenseGroup(dto.getExpenseGroup());
        budgetItem.setProjectName(dto.getProjectName());
        budgetItem.setPlanWI(dto.getPlanWI());
        budgetItem.setAdministratorOfFunds(dto.getAdministratorOfFunds());
        budgetItem.setBudget(dto.getBudget());
        budgetItem.setTaskName(dto.getTaskName());
        budgetItem.setDetailedTaskJustification(dto.getDetailedTaskJustification());
        budgetItem.setAllocationOfExpenses(dto.getAllocationOfExpenses());

        // Year fields...
        budgetItem.setFinancialNeedsFor2026(dto.getFinancialNeedsFor2026());
        budgetItem.setLimitOfExpensesFor2026(dto.getLimitOfExpensesFor2026());
        budgetItem.setFirstMoneyForRealizationIn2026(dto.getFirstMoneyForRealizationIn2026());
        budgetItem.setMoneyInAgreementFor2026(dto.getMoneyInAgreementFor2026());
        budgetItem.setAgreementNumberFor2026(dto.getAgreementNumberFor2026());

        budgetItem.setFinancialNeedsFor2027(dto.getFinancialNeedsFor2027());
        budgetItem.setLimitOfExpensesFor2027(dto.getLimitOfExpensesFor2027());
        budgetItem.setFirstMoneyForRealizationIn2026(dto.getFirstMoneyForRealizationIn2026());
        budgetItem.setMoneyInAgreementFor2027(dto.getMoneyInAgreementFor2027());
        budgetItem.setAgreementNumberFor2027(dto.getAgreementNumberFor2027());

        budgetItem.setFinancialNeedsFor2028(dto.getFinancialNeedsFor2028());
        budgetItem.setLimitOfExpensesFor2028(dto.getLimitOfExpensesFor2028());
        budgetItem.setFirstMoneyForRealizationIn2026(dto.getFirstMoneyForRealizationIn2026());
        budgetItem.setMoneyInAgreementFor2028(dto.getMoneyInAgreementFor2028());
        budgetItem.setAgreementNumberFor2028(dto.getAgreementNumberFor2028());
        budgetItem.setFinancialNeedsFor2028(dto.getFinancialNeedsFor2028());

        budgetItem.setLimitOfExpensesFor2029(dto.getLimitOfExpensesFor2029());
        budgetItem.setFirstMoneyForRealizationIn2026(dto.getFirstMoneyForRealizationIn2026());
        budgetItem.setMoneyInAgreementFor2029(dto.getMoneyInAgreementFor2029());
        budgetItem.setAgreementNumberFor2029(dto.getAgreementNumberFor2029());

        budgetItem.setContractWith(dto.getContractWith());
        budgetItem.setLegalBasisForSubsidy(dto.getLegalBasisForSubsidy());
        budgetItem.setComments(dto.getComments());

        return budgetItemRepository.save(budgetItem);
    }

    @Override
    public List<BudgetItem> getAllBudgetItems() {
        // TODO add proper user validation
        return budgetItemRepository.findAll();
    }

    @Override
    @Transactional
    public BudgetItem updatePartialBudgetItem(Long id, BudgetItemDto dto) {
        BudgetItem existingBudgetItem = getBudgetItemById(id);

//        // Load related entities by ID only if provided in DTO
//        if (dto.getBudgetPartId() != null && !dto.getBudgetPartId().equals(existingBudgetItem.getBudgetPart().getId())) {
//            existingBudgetItem.setBudgetPart(
//                    budgetPartRepository.findById(dto.getBudgetPartId())
//                            .orElseThrow(() -> new RuntimeException("BudgetPart not found"))
//            );
//        }
//
//        if (dto.getSectionId() != null && !dto.getSectionId().equals(existingBudgetItem.getSection().getId())) {
//            existingBudgetItem.setSection(
//                    sectionRepository.findById(dto.getSectionId())
//                            .orElseThrow(() -> new RuntimeException("Section not found"))
//            );
//        }
//
//        if (dto.getSubSectionId() != null && !dto.getSubSectionId().equals(existingBudgetItem.getSubSection().getId())) {
//            existingBudgetItem.setSubSection(
//                    subSectionRepository.findById(dto.getSubSectionId())
//                            .orElseThrow(() -> new RuntimeException("SubSection not found"))
//            );
//        }
//
//        if (dto.getParagraphId() != null && !dto.getParagraphId().equals(existingBudgetItem.getParagraph().getId())) {
//            existingBudgetItem.setParagraph(
//                    paragraphRepository.findById(dto.getParagraphId())
//                            .orElseThrow(() -> new RuntimeException("Paragraph not found"))
//            );
//        }
//
//        // System.out.println(dto.getFinanceSourceId());
//
//        if (dto.getFinanceSourceId() != null && !dto.getFinanceSourceId().equals(existingBudgetItem.getFinanceSource().getId())) {
//            existingBudgetItem.setFinanceSource(
//                    financeSourceRepository.findById(dto.getFinanceSourceId())
//                            .orElseThrow(() -> new RuntimeException("FinanceSource not found"))
//            );
//        }
//
//        if (dto.getDepartmentId() != null && !dto.getDepartmentId().equals(existingBudgetItem.getDepartment().getId())) {
//            existingBudgetItem.setDepartment(
//                    departmentRepository.findById(dto.getDepartmentId())
//                            .orElseThrow(() -> new RuntimeException("Department not found"))
//            );
//        }
//
//        if (dto.getActionId() != null && !dto.getActionId().equals(existingBudgetItem.getAction().getId())) {
//            existingBudgetItem.setAction(
//                    actionRepository.findById(dto.getActionId())
//                            .orElseThrow(() -> new RuntimeException("Action not found"))
//            );
//        }

        // Update scalar fields only if provided (non-null)
        if (dto.getExpenseGroup() != null) {
            existingBudgetItem.setExpenseGroup(dto.getExpenseGroup());
        }
        if (dto.getProjectName() != null) {
            existingBudgetItem.setProjectName(dto.getProjectName());
        }
        if (dto.getPlanWI() != null) {
            existingBudgetItem.setPlanWI(dto.getPlanWI());
        }
        if (dto.getAdministratorOfFunds() != null) {
            existingBudgetItem.setAdministratorOfFunds(dto.getAdministratorOfFunds());
        }
        if (dto.getBudget() != null) {
            existingBudgetItem.setBudget(dto.getBudget());
        }
        if (dto.getTaskName() != null) {
            existingBudgetItem.setTaskName(dto.getTaskName());
        }
        if (dto.getDetailedTaskJustification() != null) {
            existingBudgetItem.setDetailedTaskJustification(dto.getDetailedTaskJustification());
        }
        if (dto.getAllocationOfExpenses() != null) {
            existingBudgetItem.setAllocationOfExpenses(dto.getAllocationOfExpenses());
        }

        // Financial fields for 2026
        if (dto.getFinancialNeedsFor2026() != null) {
            existingBudgetItem.setFinancialNeedsFor2026(dto.getFinancialNeedsFor2026());
        }
        if (dto.getLimitOfExpensesFor2026() != null) {
            existingBudgetItem.setLimitOfExpensesFor2026(dto.getLimitOfExpensesFor2026());
        }
        if (dto.getFirstMoneyForRealizationIn2026() != null) {
            existingBudgetItem.setFirstMoneyForRealizationIn2026(dto.getFirstMoneyForRealizationIn2026());
        }
        if (dto.getMoneyInAgreementFor2026() != null) {
            existingBudgetItem.setMoneyInAgreementFor2026(dto.getMoneyInAgreementFor2026());
        }
        if (dto.getAgreementNumberFor2026() != null) {
            existingBudgetItem.setAgreementNumberFor2026(dto.getAgreementNumberFor2026());
        }

        // Financial fields for 2027
        if (dto.getFinancialNeedsFor2027() != null) {
            existingBudgetItem.setFinancialNeedsFor2027(dto.getFinancialNeedsFor2027());
        }
        if (dto.getLimitOfExpensesFor2027() != null) {
            existingBudgetItem.setLimitOfExpensesFor2027(dto.getLimitOfExpensesFor2027());
        }
        if (dto.getSecondMoneyForRealizationIn2026() != null) {
            existingBudgetItem.setSecondMoneyForRealizationIn2026(dto.getSecondMoneyForRealizationIn2026());
        }
        if (dto.getMoneyInAgreementFor2027() != null) {
            existingBudgetItem.setMoneyInAgreementFor2027(dto.getMoneyInAgreementFor2027());
        }
        if (dto.getAgreementNumberFor2027() != null) {
            existingBudgetItem.setAgreementNumberFor2027(dto.getAgreementNumberFor2027());
        }

        // Financial fields for 2028
        if (dto.getFinancialNeedsFor2028() != null) {
            existingBudgetItem.setFinancialNeedsFor2028(dto.getFinancialNeedsFor2028());
        }
        if (dto.getLimitOfExpensesFor2028() != null) {
            existingBudgetItem.setLimitOfExpensesFor2028(dto.getLimitOfExpensesFor2028());
        }
        if (dto.getThirdMoneyForRealizationIn2026() != null) {
            existingBudgetItem.setThirdMoneyForRealizationIn2026(dto.getThirdMoneyForRealizationIn2026());
        }
        if (dto.getMoneyInAgreementFor2028() != null) {
            existingBudgetItem.setMoneyInAgreementFor2028(dto.getMoneyInAgreementFor2028());
        }
        if (dto.getAgreementNumberFor2028() != null) {
            existingBudgetItem.setAgreementNumberFor2028(dto.getAgreementNumberFor2028());
        }

        // Financial fields for 2029
        if (dto.getFinancialNeedsFor2029() != null) {
            existingBudgetItem.setFinancialNeedsFor2029(dto.getFinancialNeedsFor2029());
        }
        if (dto.getLimitOfExpensesFor2029() != null) {
            existingBudgetItem.setLimitOfExpensesFor2029(dto.getLimitOfExpensesFor2029());
        }
        if (dto.getForthMoneyForRealizationIn2026() != null) {
            existingBudgetItem.setForthMoneyForRealizationIn2026(dto.getForthMoneyForRealizationIn2026());
        }
        if (dto.getMoneyInAgreementFor2029() != null) {
            existingBudgetItem.setMoneyInAgreementFor2029(dto.getMoneyInAgreementFor2029());
        }
        if (dto.getAgreementNumberFor2029() != null) {
            existingBudgetItem.setAgreementNumberFor2029(dto.getAgreementNumberFor2029());
        }

        // Other fields
        if (dto.getContractWith() != null) {
            existingBudgetItem.setContractWith(dto.getContractWith());
        }
        if (dto.getLegalBasisForSubsidy() != null) {
            existingBudgetItem.setLegalBasisForSubsidy(dto.getLegalBasisForSubsidy());
        }
        if (dto.getComments() != null) {
            existingBudgetItem.setComments(dto.getComments());
        }

        return budgetItemRepository.save(existingBudgetItem);
    }

    @Override
    public BudgetItem getBudgetItemById(Long id) {
        return budgetItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BudgetItem not found with id: " + id));
    }

    @Override
    public List<BudgetItem> getBudgetItemByDepartmentId(Long departmentId) {
        return budgetItemRepository.findAllByDepartmentId(departmentId);
    }

    private void updateNonNullFields(BudgetItem source, BudgetItem target) {
        if (source.getBudgetPart() != null) target.setBudgetPart(source.getBudgetPart());
        if (source.getSection() != null) target.setSection(source.getSection());
        if (source.getSubSection() != null) target.setSubSection(source.getSubSection());
        if (source.getParagraph() != null) target.setParagraph(source.getParagraph());
        if (source.getFinanceSource() != null) target.setFinanceSource(source.getFinanceSource());
        if (source.getExpenseGroup() != null) target.setExpenseGroup(source.getExpenseGroup());
        if (source.getAction() != null) target.setAction(source.getAction());
        if (source.getProjectName() != null) target.setProjectName(source.getProjectName());
        if (source.getDepartment() != null) target.setDepartment(source.getDepartment());
        if (source.getPlanWI() != null) target.setPlanWI(source.getPlanWI());
        if (source.getAdministratorOfFunds() != null) target.setAdministratorOfFunds(source.getAdministratorOfFunds());
        if (source.getBudget() != null) target.setBudget(source.getBudget());
        if (source.getTaskName() != null) target.setTaskName(source.getTaskName());
        if (source.getDetailedTaskJustification() != null) target.setDetailedTaskJustification(source.getDetailedTaskJustification());
        if (source.getAllocationOfExpenses() != null) target.setAllocationOfExpenses(source.getAllocationOfExpenses());
        if (source.getFinancialNeedsFor2026() != null) target.setFinancialNeedsFor2026(source.getFinancialNeedsFor2026());
        if (source.getLimitOfExpensesFor2026() != null) target.setLimitOfExpensesFor2026(source.getLimitOfExpensesFor2026());
        if (source.getFirstMoneyForRealizationIn2026() != null) target.setFirstMoneyForRealizationIn2026(source.getFirstMoneyForRealizationIn2026());
        if (source.getMoneyInAgreementFor2026() != null) target.setMoneyInAgreementFor2026(source.getMoneyInAgreementFor2026());
        if (source.getAgreementNumberFor2026() != null) target.setAgreementNumberFor2026(source.getAgreementNumberFor2026());
        if (source.getFinancialNeedsFor2027() != null) target.setFinancialNeedsFor2027(source.getFinancialNeedsFor2027());
        if (source.getLimitOfExpensesFor2027() != null) target.setLimitOfExpensesFor2027(source.getLimitOfExpensesFor2027());
        if (source.getSecondMoneyForRealizationIn2026() != null) target.setSecondMoneyForRealizationIn2026(source.getSecondMoneyForRealizationIn2026());
        if (source.getMoneyInAgreementFor2027() != null) target.setMoneyInAgreementFor2027(source.getMoneyInAgreementFor2027());
        if (source.getAgreementNumberFor2027() != null) target.setAgreementNumberFor2027(source.getAgreementNumberFor2027());
        if (source.getFinancialNeedsFor2028() != null) target.setFinancialNeedsFor2028(source.getFinancialNeedsFor2028());
        if (source.getLimitOfExpensesFor2028() != null) target.setLimitOfExpensesFor2028(source.getLimitOfExpensesFor2028());
        if (source.getThirdMoneyForRealizationIn2026() != null) target.setThirdMoneyForRealizationIn2026(source.getThirdMoneyForRealizationIn2026());
        if (source.getMoneyInAgreementFor2028() != null) target.setMoneyInAgreementFor2028(source.getMoneyInAgreementFor2028());
        if (source.getAgreementNumberFor2028() != null) target.setAgreementNumberFor2028(source.getAgreementNumberFor2028());
        if (source.getFinancialNeedsFor2029() != null) target.setFinancialNeedsFor2029(source.getFinancialNeedsFor2029());
        if (source.getLimitOfExpensesFor2029() != null) target.setLimitOfExpensesFor2029(source.getLimitOfExpensesFor2029());
        if (source.getForthMoneyForRealizationIn2026() != null) target.setForthMoneyForRealizationIn2026(source.getForthMoneyForRealizationIn2026());
        if (source.getMoneyInAgreementFor2029() != null) target.setMoneyInAgreementFor2029(source.getMoneyInAgreementFor2029());
        if (source.getAgreementNumberFor2029() != null) target.setAgreementNumberFor2029(source.getAgreementNumberFor2029());
        if (source.getContractWith() != null) target.setContractWith(source.getContractWith());
        if (source.getLegalBasisForSubsidy() != null) target.setLegalBasisForSubsidy(source.getLegalBasisForSubsidy());
        if (source.getComments() != null) target.setComments(source.getComments());
    }
//
//    /**
//     * Acquire lock for editing
//     * Throws exception if lock cannot be obtained
//     */
//    @Override
//    public BudgetItem findByIdForUpdate(Long budgetItemId) {
//        return budgetItemRepository.findByIdForUpdate(budgetItemId)
//                .orElseThrow(() -> new EntityNotFoundException(
//                        "BudgetItem not found: " + budgetItemId
//                ));
//    }
//
//    /**
//     * Try to acquire lock with NO_WAIT
//     * Returns Optional - empty if already locked
//     */
//    @Transactional
//    @Override
//    public Optional<BudgetItem> tryLockForEditing(Long budgetItemId) {
//        try {
//            return budgetItemRepository.findByIdNoWait(budgetItemId);
//        } catch (LockTimeoutException e) {
//            return Optional.empty();  // Already locked, don't wait
//        }
//    }
//
//    /**
//     * Acquire lock for reading only
//     */
//    @Transactional
//    @Override
//    public BudgetItem lockForReading(Long budgetItemId) {
//        return budgetItemRepository.findByIdForRead(budgetItemId)
//                .orElseThrow(() -> new EntityNotFoundException(
//                        "BudgetItem not found: " + budgetItemId
//                ));
//    }
}
