package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.dicts.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParagraphRepository extends JpaRepository<Paragraph, String> {
}
