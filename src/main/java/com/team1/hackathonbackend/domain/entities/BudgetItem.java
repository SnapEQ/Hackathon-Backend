package com.team1.hackathonbackend.domain.entities;

import com.team1.hackathonbackend.domain.entities.dicts.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "budget_item")
@Audited
public class BudgetItem {
    @Id
    private Long budgetItemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_part_id")
    private BudgetPart budgetPart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_section_id")
    private SubSection subSection;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paragraph_id")
    private Paragraph paragraph;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finance_source_id")
    private FinanceSource financeSource;

    private String test;
}
