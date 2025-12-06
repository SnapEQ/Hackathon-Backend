package com.team1.hackathonbackend.domain.entities.dicts;

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
@Table(name = "departaments")
public class Department { // Dział
    @Id
    private String departmentId;

    private String name;
}
