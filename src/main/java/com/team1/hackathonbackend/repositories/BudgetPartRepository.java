package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.dicts.BudgetPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetPartRepository extends JpaRepository<BudgetPart, String> {
}
