package com.project.fitness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String type;
    @Column(length=2000)
    private String recommendation;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> improvements;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> suggestions;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> safety;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}