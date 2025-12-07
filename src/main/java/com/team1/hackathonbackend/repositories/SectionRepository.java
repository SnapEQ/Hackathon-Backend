package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.dicts.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, String> {
}
