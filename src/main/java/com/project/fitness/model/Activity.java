package com.project.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_activity_user")
    )
    @JsonIgnore
    private User user;

    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String, Object> additionalMetrics;

    private Integer duration;

    private String caloriesBurned;

    private LocalTime startTime;
    @CreationTimestamp
    private LocalTime createTime;
    @UpdateTimestamp
    private LocalTime updateTime;

    @OneToMany(
            mappedBy = "activity",
            cascade = jakarta.persistence.CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Recommendation> recommendations = new ArrayList<>();
}