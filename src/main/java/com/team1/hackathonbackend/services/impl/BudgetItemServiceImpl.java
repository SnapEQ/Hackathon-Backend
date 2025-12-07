package com.team1.hackathonbackend.services.impl;

import com.team1.hackathonbackend.domain.entities.BudgetItem;
import com.team1.hackathonbackend.repositories.BudgetItemRepository;
import com.team1.hackathonbackend.services.BudgetItemService;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    public BudgetItem createBudgetItem(BudgetItem budgetItem) {
        // TODO Add proper validation
        // TODO Add proper user validation
        return budgetItemRepository.save(budgetItem);
    }

    @Override
    public List<BudgetItem> getAllBudgetItems() {
        // TODO add proper user validation
        return budgetItemRepository.findAll();
    }

    @Override
    public BudgetItem updatePartialBudgetItem(Long id, BudgetItem budgetItem) {
        BudgetItem existingBudgetItem = getBudgetItemById(id);

        updateNonNullFields(budgetItem, existingBudgetItem);

        return budgetItemRepository.save(existingBudgetItem);
    }

    @Override
    public BudgetItem getBudgetItemById(Long id) {
        return budgetItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BudgetItem not found with id: " + id));
    }

    @Override
    public List<BudgetItem> getBudgetItemByDepartmentId(Long departmentId) {
        return budgetItemRepository.findAllByDepartment_Id(departmentId);
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


}
