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
@Table(name = "paragraphs") // Dict
public class Paragraph { // Paragrafy
    @Id
    private String paragraphId;

    private String name;
}
