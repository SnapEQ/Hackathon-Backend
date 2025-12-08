package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.dicts.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {
}
