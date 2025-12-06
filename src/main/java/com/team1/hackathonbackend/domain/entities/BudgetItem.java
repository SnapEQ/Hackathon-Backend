package com.team1.hackathonbackend.domain.entities;

import com.team1.hackathonbackend.domain.entities.dicts.*;
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
    private BudgetPart budgetPart;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Section section;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_section_id")
    private SubSection subSection;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paragraph_id")
    private Paragraph paragraph;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finance_source_id")
    private FinanceSource financeSource;

    private String test;
}
