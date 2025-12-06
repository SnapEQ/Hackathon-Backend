package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.BudgetItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetItemRepository extends JpaRepository<BudgetItem, Long> {
}
