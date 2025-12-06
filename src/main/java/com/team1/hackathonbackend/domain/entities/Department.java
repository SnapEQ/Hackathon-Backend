package com.team1.hackathonbackend.domain.entities;

import com.team1.hackathonbackend.domain.entities.dicts.BudgetPart;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(nullable = false)
    private Long id;

    private String name;
}
