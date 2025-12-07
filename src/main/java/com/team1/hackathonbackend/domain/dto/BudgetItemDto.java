package com.team1.hackathonbackend.domain.dto;

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
    // Reference IDs instead of full objects
    private String budgetPartId;
    private String sectionId;
    private String subSectionId;
    private String paragraphId;
    private String financeSourceId;
    private Long departmentId;
    private Long actionId;

    private String expenseGroup; // Grupa wydatków

    private String projectName; // Nazwa programu/projektu

    private String planWI; // Plan WI

    private String administratorOfFunds; // Dysponent środków

    private String budget; // Budżet

    private String taskName; // Nazwa zadania

    private String detailedTaskJustification; // Szczegółowe uzasadnienie realizacji zdania

    private String allocationOfExpenses; // Przeznaczenie wydatków wg obszaru działalności: cyberbezpieczeństwo/sztuczna inteligencja/koszty funkcjonowania/inne (wpisać jakie?)

    private Integer financialNeedsFor2026; // Potrzeby finansowe na 2026 rok
    private Integer limitOfExpensesFor2026; // Limit wydatków na rok 2026
    private Integer firstMoneyForRealizationIn2026; // "Kwota na realizację zadań w 2026 roku, która nie została zabezpieczona w limicie (kol. 17-kol. 18)"
    private Integer moneyInAgreementFor2026; // Kwota zawartej umowy/wniosku o udzielenie zamówienia publicznego
    private String agreementNumberFor2026; // Nr umowy/nr wniosku o udzielenie zamówienia publicznego

    private Integer financialNeedsFor2027; // Potrzeby finansowe na 2027 rok
    private Integer limitOfExpensesFor2027; // Limit wydatków na rok 2027
    private Integer secondMoneyForRealizationIn2026; // "Kwota na realizację zadań w 2026 roku, która nie została zabezpieczona w limicie (kol. 22-kol. 23)"
    private Integer moneyInAgreementFor2027; // Kwota zawartej umowy/wniosku o udzielenie zamówienia publicznego
    private String agreementNumberFor2027; // Nr umowy/nr wniosku o udzielenie zamówienia publicznego

    private Integer financialNeedsFor2028; // Potrzeby finansowe na 2028 rok
    private Integer limitOfExpensesFor2028; // Limit wydatków na rok 2028
    private Integer thirdMoneyForRealizationIn2026; // "Kwota na realizację zadań w 2026 roku, która nie została zabezpieczona w limicie (kol. 27-kol. 28)"
    private Integer moneyInAgreementFor2028; // Kwota zawartej umowy/wniosku o udzielenie zamówienia publicznego
    private String agreementNumberFor2028; // Nr umowy/nr wniosku o udzielenie zamówienia publicznego

    private Integer financialNeedsFor2029; // Potrzeby finansowe na 2029 rok
    private Integer limitOfExpensesFor2029; // Limit wydatków na rok 2029
    private Integer forthMoneyForRealizationIn2026; // "Kwota na realizację zadań w 2026 roku, która nie została zabezpieczona w limicie (kol. 32-kol. 33)"
    private Integer moneyInAgreementFor2029; // Kwota zawartej umowy/wniosku o udzielenie zamówienia publicznego
    private String agreementNumberFor2029; // Nr umowy/nr wniosku o udzielenie zamówienia publicznego

    private String contractWith; // W przypadku dotacji - z kim zawarta umowa/planowana do zawarcia umowa
    private String legalBasisForSubsidy;
    private String comments;
}
