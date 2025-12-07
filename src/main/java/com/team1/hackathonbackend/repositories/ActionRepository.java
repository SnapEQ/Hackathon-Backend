package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.tasks.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}
