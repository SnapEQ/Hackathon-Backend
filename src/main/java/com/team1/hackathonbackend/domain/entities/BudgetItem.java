package com.team1.hackathonbackend.domain.entities;

import com.team1.hackathonbackend.domain.entities.dicts.*;
import com.team1.hackathonbackend.domain.entities.tasks.Action;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "budget_item")
@Audited
public class BudgetItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budget_item_id_seq")
    private Long id;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_part_id")
    private BudgetPart budgetPart; // Część budżetowa

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Section section; // Dział

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_section_id")
    private SubSection subSection; // Rozdział

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paragraph_id")
    private Paragraph paragraph; // Paragraf

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finance_source_id")
    private FinanceSource financeSource; // Źródło finansowania

    private String expenseGroup; // Grupa wydatków

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "action_id")
    private Action action; // Z tąd można sobie wziąć zadania

    private String projectName; // Nazwa programu/projektu

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department; // Nazwa komórki organizacyjnej

    private String planWI; // Plan WI

    private String administratorOfFunds; // Dysponent środków

    private String budget; // Budżet

    private String taskName; // Nazwa zadania

    private String detailedTaskJustification; // Szczegółowe uzasadnienie realizacji zdania

    private String allocationOfExpenses; // Przeznaczenie wydatków wg obszaru działalności: cyberbezpieczeństwo/sztuczna inteligencja/koszty funkcjonowania/inne (wpisać jakie?)

    private Integer financialNeedsFor2026; // Potrzeby finansowe na 2026 rok
    private Integer limitOfExpensesFor2026; // Limit wydatków na rok 2026
    private Integer firstMoneyForRealizationIn2026; // "Kwota na realizację zadań w 2026 roku, która nie została zabezpieczona w limicie (kol. 17-kol. 18)"
    private Integer MoneyInAgreementFor2026; // Kwota zawartej umowy/wniosku o udzielenie zamówienia publicznego
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
