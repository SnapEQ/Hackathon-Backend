package com.team1.hackathonbackend.domain.entities.dicts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "budget_parts") // Część Budżetowa
public class BudgetPart {
    @Id
    @Column(nullable = false)
    private String id;

    private String name;
}
