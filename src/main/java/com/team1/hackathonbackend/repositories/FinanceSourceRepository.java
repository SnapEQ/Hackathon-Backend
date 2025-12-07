package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.dicts.FinanceSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceSourceRepository extends JpaRepository<FinanceSource, String> {
}
