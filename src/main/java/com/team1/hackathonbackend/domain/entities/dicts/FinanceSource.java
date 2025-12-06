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
@Table(name = "finance_sources") // Dict
public class FinanceSource { // Źródło Finansowania
    @Id
    @Column(nullable = false)
    private String financeSourceId;

    private String name;

}
